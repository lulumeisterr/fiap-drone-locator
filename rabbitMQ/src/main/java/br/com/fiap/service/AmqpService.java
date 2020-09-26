package br.com.fiap.service;

import br.com.fiap.dto.Message;

/**
 * Test Service
 */
public interface AmqpService {

	void sendToConsumer(Message message);
	
}
