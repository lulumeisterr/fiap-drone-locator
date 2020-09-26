package br.com.fiap.drone.dto;

public class Text {

	private Float temperatura;

	private Float umidade;
	
	private Long idDrone;

	public Text() {
		// TODO Auto-generated constructor stub
	}

	public Text(Float temperatura, Float umidade, Long idDrone) {
		super();
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.idDrone = idDrone;
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

	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	
	
	
}
