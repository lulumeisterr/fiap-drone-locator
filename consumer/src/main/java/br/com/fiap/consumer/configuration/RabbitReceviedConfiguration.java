package br.com.fiap.consumer.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Retornar Json tratado recebido da Fila
 * @author lucasrodriguesdonascimento
 *
 */
@Configuration
public class RabbitReceviedConfiguration {
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper;
	}
	
	
	@Bean
	public MessageConverter jsonConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public SimpleRabbitListenerContainerFactory SimpleRabbitListenerContainerFactory
	(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory,SimpleRabbitListenerContainerFactoryConfigurer configure) {

		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

		configure.configure(factory, connectionFactory);
		factory.setMessageConverter(jsonConverter());

		return factory;

	}

}
