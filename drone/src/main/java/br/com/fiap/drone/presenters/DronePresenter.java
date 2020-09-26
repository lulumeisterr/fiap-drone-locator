package br.com.fiap.drone.presenters;

import java.io.Serializable;

public class DronePresenter implements Serializable{

	private static final long serialVersionUID = 4058774097473483229L;
	
	private Long id;
	private Double latitude;
	private Double longitude;
	private Float temperatura;
	private Float umidade;
	
	public DronePresenter() {
		// TODO Auto-generated constructor stub
	}

	public DronePresenter(Long id, Double latitude, Double longitude, Float temperatura, Float umidade) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperatura = temperatura;
		this.umidade = umidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
