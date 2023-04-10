package org.svb.leaseacar.entities.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;

	@GetMapping
	public List<Vehicle> findAllVehicles() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> findVehicleById(@PathVariable(value = "id") long id) {
		Optional<Vehicle> vehicles = vehicleRepository.findById(id);
		return vehicles.map(value -> ResponseEntity.ok().body(value)).orElseGet(()
				-> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Vehicle saveVehicle(@Validated @RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
}
