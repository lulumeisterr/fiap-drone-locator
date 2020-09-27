package br.com.fiap.drone.service;

import java.util.List;

import br.com.fiap.drone.entity.Drone;
import br.com.fiap.drone.presenters.DronePresenter;

public interface DroneService {
	
	DronePresenter createDrone(DronePresenter dronePresenter);
	List<Drone> findAllDrone();

}
