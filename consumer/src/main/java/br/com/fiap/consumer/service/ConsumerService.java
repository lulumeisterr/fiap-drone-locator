package br.com.fiap.consumer.service;

import br.com.fiap.consumer.dto.Message;

/**
 * Classe responsavel por receber a informacao consumida e realizar alguma acao no sistema
 * @author lucasrodriguesdonascimento
 *
 */
public interface ConsumerService {
	
	void action(Message message)throws Exception;
	

}
