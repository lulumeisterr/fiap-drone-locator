package br.com.fiap.consumer.service.implementation;

import org.springframework.stereotype.Service;

import br.com.fiap.consumer.dto.Message;
import br.com.fiap.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(Message message) throws Exception {
		System.out.println(message.getText());
	}

}
