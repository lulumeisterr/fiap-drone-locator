package br.com.fiap.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.drone.entity.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long>{

}
