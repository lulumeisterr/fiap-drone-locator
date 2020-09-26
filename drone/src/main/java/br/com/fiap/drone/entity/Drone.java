package br.com.fiap.drone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DRONE")
public class Drone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double latitude;
	
	@Column
	private Double longitude;
	
	@Column
	private Float temperatura;
	
	@Column
	private Float umidade;
	
	
	public Drone() {
		// TODO Auto-generated constructor stub
	}


	public Drone(Long id, Double latitude, Double longitude, Float temperatura, Float umidade) {
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

	

}
