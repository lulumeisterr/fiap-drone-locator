package br.com.fiap.consumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.consumer.amqp.AmqpConsumer;
import br.com.fiap.consumer.dto.Message;
import br.com.fiap.consumer.service.ConsumerService;

/**
 * Classe responsavel por ser ouvinte das filas de rabbitmq
 * @author lucasrodriguesdonascimento
 *
 */
@Component
public class RabbitMQConsumer implements AmqpConsumer<Message>{

	@Autowired
	private ConsumerService consumerService;

	/**
	 * Anotacao @RabbitListener 
	 *  Rabbit message listener on the specified queues() (or bindings())
	 */
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.template.routing-key}")
	public void consumer(Message mensagem) {
		try {
			consumerService.action(mensagem);
		}catch(Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}

	}

}
