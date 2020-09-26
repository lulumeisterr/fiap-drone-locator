package br.com.fiap.consumer.amqp;

/**
 * Responsavel por realizar o consume de qualquer broker AMQP
 * @author lucasrodriguesdonascimento
 *
 */
public interface AmqpConsumer<T> {
	
	void consumer(T t);

}
