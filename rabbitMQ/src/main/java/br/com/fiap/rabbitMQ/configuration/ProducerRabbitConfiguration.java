package br.com.fiap.rabbitMQ.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracao detalhada para producers , Caso vc tenha 
 * mais de uma fila em sua aplicacao essa configuracao serve para este contexto.
 * 
 * 
 * Quando a aplicacao startar as filas ja seram adicionadas no RabbitMQ queue
 * 
 * @author lucasrodriguesdonascimento
 *
 */
@Configuration
public class ProducerRabbitConfiguration {

	@Value("${spring.rabbitmq.template.routing-key}")
	private String queue;

	@Value("${spring.rabbitmq.template.exchange}")
	private String exchange;

	@Value("${deadletter.producer}")
	private String deadletter;


	/**
	 * 
		Exchange -> Recebe a mensagem enviada pelo Produto e encaminha a 
		mensagem para a fila destinada pelo produtor.
	 * @return
	 */
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	/**
	 * DeadLetter Queue para receber as mensagens que deram erro
	 * e quando o aplicacao que deu erro voltar, passar a consumir
	 * da deadLetter
	 */
	
	@Bean
	Queue deadLetter() {
		return new Queue(deadletter);
	}
	
	/**
	 * Associar a Queue a deadLetter , pois a deadLetter esta associado a uma
	 * queue caso de erro
	 * 
	 * Construtor da Queue :
	 * 
	 * Nome da queie
	 * Duravel
	 * Tirando auto exclusao
	 * Tirando auto complite
	 * Associando a queue a deadLetter
	 * 
	 * @return
	 */
	@Bean
	Queue queue() {
		Map<String,Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", exchange);
		args.put("x-dead-letter-routing-key", deadletter);
		return new Queue(queue,true,false,false,args);
	}
	
	@Bean
	public Binding bindingQueue() {
		return BindingBuilder.bind(queue()).to(exchange()).with(queue);
	}
	
	/**
	 * Atrela a deadLetter a fila
	 * @return
	 */
	@Bean
	public Binding bindingQueueDeadLetter() {
		return BindingBuilder.bind(deadLetter()).to(exchange()).with(deadletter);
	}
	
	

}
