package br.com.fiap.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.drone.entity.Drone;
import br.com.fiap.drone.presenters.DronePresenter;
import br.com.fiap.drone.service.DroneService;

@RestController
@RequestMapping("drones")
public class DroneController {
	
	@Autowired
	private DroneService droneService;
	
	/**
	 * Cadastrar drone
	 * @param dronePresenter
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DronePresenter addDrone(@RequestBody DronePresenter dronePresenter){
		return droneService.createDrone(dronePresenter);
	}
	
	/**
	 * Localizar drone
	 */
	@GetMapping()
	public List<Drone> getAll() {
		List<Drone> lista = droneService.findAllDrone();
		return lista;
	}
	
}
