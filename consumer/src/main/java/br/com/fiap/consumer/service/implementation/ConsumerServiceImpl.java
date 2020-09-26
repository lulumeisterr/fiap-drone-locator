package br.com.fiap.consumer.service.implementation;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.fiap.consumer.dto.Message;
import br.com.fiap.consumer.sendEmail.Email;
import br.com.fiap.consumer.service.ConsumerService;

/**
 * (Temperatura >= 35 ou <= 0) OU (Umidade do ar <= 15%).
Para enviar e-mail pode usar um SaaS.

 * @author lucasrodriguesdonascimento
 *
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	private Email email;

	@Override
	public void action(Message message) throws Exception {
		System.out.println("Temperatura : "+ message.getText().getTemperatura() + 
				" E " + " Umidade : " + message.getText().getUmidade() + message.getText().getIdDrone());

		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					regra(message);
				} catch (Exception e ) {
					e.printStackTrace();
				}

			}
		}).start();

	}

	private void regra(Message message) throws InterruptedException {
		if(message.getText().getTemperatura() >= 35 || message.getText().getTemperatura() <= 0 
				|| message.getText().getUmidade() <= 15){

			StringBuilder msgEmail = new StringBuilder()
					.append(" ID DO DRONE : " + message.getText().getIdDrone()).append("\n")
					.append(" Temperatura : " + message.getText().getTemperatura()).append("\n")
					.append(" Umidade : " + message.getText().getUmidade());

			System.out.println("Aguardando 1m para encaminhar o email");
			TimeUnit.MINUTES.sleep(1);

			System.out.println("Encaminhando Email");
			email.sendEmail(msgEmail.toString());
		}else {
			System.out.println("Sem Emails para encaminhar");
		}
	}

}
