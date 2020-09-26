package br.com.fiap.drone.dto;

public class Text {

	private Float temperatura;

	private Float umidade;

	public Text() {
		// TODO Auto-generated constructor stub
	}

	public Text(Float temperatura, Float umidade) {
		super();
		this.temperatura = temperatura;
		this.umidade = umidade;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public Float getUmidade() {
		return umidade;
	}

	public void setUmidade(Float umidade) {
		this.umidade = umidade;
	}
	
	
	
}
