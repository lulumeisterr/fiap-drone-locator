package br.com.fiap.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.fiap.amqp.AmqpProducer;
import br.com.fiap.dto.Message;

@Component
public class ProducerRabbitImpl implements AmqpProducer<Message> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.template.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.template.routing-key}")
	private String queue;
	
	@Override
	public void producer(Message message) {
		
		try {
			
			rabbitTemplate.convertAndSend(exchange,queue,message);
			
		}catch(Exception e) {
			/**
			 * Quando der Erro , sera enviada pela deadletter
			 */
			throw new AmqpRejectAndDontRequeueException(e);
		}
		
	}

}
