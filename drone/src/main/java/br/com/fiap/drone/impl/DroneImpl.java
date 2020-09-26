package br.com.fiap.drone.impl;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.fiap.drone.dto.Message;
import br.com.fiap.drone.dto.Text;
import br.com.fiap.drone.entity.Drone;
import br.com.fiap.drone.presenters.DronePresenter;
import br.com.fiap.drone.repository.DroneRepository;
import br.com.fiap.drone.service.DroneService;

@Service
public class DroneImpl implements DroneService {

	private org.apache.logging.log4j.Logger logger = LogManager.getLogger(DroneImpl.class);

	@Autowired
	private DroneRepository droneRepository;

	@Value("${amqp.url}")
	private String urlProducerRabbitMQ;

	/**
	 * Cadastrando um drone
	 */
	@Override
	public DronePresenter createDrone(DronePresenter dronePresenter) {

		Drone drone = new Drone();

		drone.setId(dronePresenter.getId());
		drone.setLatitude(dronePresenter.getLatitude());
		drone.setLongitude(dronePresenter.getLongitude());
		drone.setUmidade(dronePresenter.getUmidade());
		drone.setTemperatura(dronePresenter.getTemperatura());

		Drone saveDrone = droneRepository.save(drone);

		DronePresenter droneP = new DronePresenter();
		droneP.setId(saveDrone.getId());
		droneP.setLatitude(saveDrone.getLatitude());
		droneP.setLongitude(saveDrone.getLongitude());
		droneP.setUmidade(saveDrone.getUmidade());
		droneP.setTemperatura(saveDrone.getTemperatura());
		droneP.setId(saveDrone.getId());

		logger.info("DRONE GRAVADO COM SUCESSO");

		encaminhandoDadosParaFila(droneP);

		return droneP;
	}

	/**
	 * A cada 10 segundos é feito uma leitura dos dados (temperatura e umidade) e os
dados são enviados para um serviço de mensagens
	 * @param droneP
	 */
	private void encaminhandoDadosParaFila(DronePresenter droneP) {

		RestTemplate restTemplate = new RestTemplate();

		new Thread(new Runnable() {
			@Override
			public void run() {

				try {

					TimeUnit.SECONDS.sleep(10);

					logger.info("Nome: " + Thread.currentThread().getName());
					logger.info("Prioridade: " + Thread.currentThread().getPriority());
					logger.info("Estado: " + Thread.currentThread().getState());

					String json = null;
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

					Message message = new Message(new Text(droneP.getTemperatura(),droneP.getUmidade(), droneP.getId()));

					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);

					json = ow.writeValueAsString(message);
					HttpEntity<String> request = new HttpEntity<String>(json, headers);       
					ResponseEntity<String> response = restTemplate.postForEntity( urlProducerRabbitMQ, request , String.class );

					logger.info("ENCAMINHANDO MSG PARA FILA : " + json + "Status da requisicao " + response.getStatusCode());

				} catch (JsonProcessingException e) {
					e.printStackTrace();
				} catch (ResponseStatusException e) {
					e.printStackTrace();
				} catch (Exception e ) {
					e.printStackTrace();
				}

			}
		}).start();
	}

}
