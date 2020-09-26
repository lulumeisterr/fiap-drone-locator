package br.com.fiap.dto;

public class Message {

	private Text text;

	public Message() {

	}

	public Message(Text text) {
		super();
		this.text = text;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}



}
