package br.com.fiap.consumer.service.impl;

import org.springframework.stereotype.Service;

import br.com.fiap.consumer.dto.Message;
import br.com.fiap.consumer.service.ConsumerService;

/**
 * (Temperatura >= 35 ou <= 0) OU (Umidade do ar <= 15%).
Para enviar e-mail pode usar um SaaS.

 * @author lucasrodriguesdonascimento
 *
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(Message message) throws Exception {
		System.out.println("Temperatura : "+ message.getText().getTemperatura() + 
				" E " + " Umidade : " + message.getText().getUmidade() + message.getText().getId());


	}


}
