package br.com.fiap.consumer.dto;

/**
 * Classe DTO
 * @author lucasrodriguesdonascimento
 *
 */
public class Message {
	
	private String text;
	
	
	public Message() {
		
	}

	public Message(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
