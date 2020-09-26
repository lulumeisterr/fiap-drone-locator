package br.com.fiap.consumer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		if(message.getText().getTemperatura() >= 35 || message.getText().getTemperatura() <= 0 
				|| message.getText().getUmidade() <= 15){
			
			StringBuilder msgEmail = new StringBuilder()
					.append(" ID DO DRONE : " + message.getText().getIdDrone()).append("\n")
					.append(" Temperatura : " + message.getText().getTemperatura()).append("\n")
					.append(" Umidade : " + message.getText().getUmidade());
			
			System.out.println("Encaminhando Email");
			email.sendEmail(msgEmail.toString());
		}
		
	}

}
