package br.com.fiap.amqp;


/**
 * Responsavel por produzir/trabalhar qualquer messagem que trabalha no protocologo AMQP
 * @author lucasrodriguesdonascimento
 *
 */
public interface AmqpProducer<T> {
	
	void producer(T t);

}
