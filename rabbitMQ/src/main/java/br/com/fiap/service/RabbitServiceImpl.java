package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.amqp.AmqpProducer;
import br.com.fiap.dto.Message;

@Service
public class RabbitServiceImpl implements AmqpService{

	@Autowired
	private AmqpProducer<Message> amqp;
	
	@Override
	public void sendToConsumer(Message message) {
		amqp.producer(message);
	}

}
