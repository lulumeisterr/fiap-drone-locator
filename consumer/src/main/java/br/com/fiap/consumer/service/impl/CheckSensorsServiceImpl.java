package br.com.fiap.consumer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.consumer.dto.Text;
import br.com.fiap.consumer.service.CheckSensorsService;
import br.com.fiap.consumer.service.MailService;

@Service
public class CheckSensorsServiceImpl implements CheckSensorsService {

	Logger logger= LoggerFactory.getLogger(CheckSensorsServiceImpl.class);

	private MailService mailService;

	@Value(value = "${url.listar.drone}")
	private String url;

	//Configurar um bean para o restTemplate
	private RestTemplate restTemplate = new RestTemplate();

	CheckSensorsServiceImpl(MailService mailService){
		this.mailService = mailService;
	}

	@Override
	public void checkSensors() {
		logger.info("checking sensors");
		// TODO fazer busca na base de dados dos sensores, lendo o lidar  e validando a regra

		ResponseEntity<Text[]> response = restTemplate.getForEntity(url, Text[].class);
		
//		for (Text message : response.getBody()) {
//			if(message.getTemperatura() >= 35 || message.getTemperatura() <= 0
//					|| message.getUmidade() <= 15){
//
//				StringBuilder msgEmail = new StringBuilder()
//						.append(" ID DO DRONE : " + message.getId()).append("\n")
//						.append(" Temperatura : " + message.getTemperatura()).append("\n")
//						.append(" Umidade : " + message.getUmidade());
//
//				mailService.sendEmail(msgEmail.toString());
//			}else {
//				logger.info("Sem Email para encaminhar");
//			}
		}
	
	}

