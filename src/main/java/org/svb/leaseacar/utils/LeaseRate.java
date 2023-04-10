package org.svb.leaseacar.utils;

import org.springframework.web.bind.annotation.*;
import org.svb.leaseacar.entities.interest.Interest;
import org.svb.leaseacar.entities.interest.InterestController;
import org.svb.leaseacar.entities.vehicles.Vehicle;
import org.svb.leaseacar.entities.vehicles.VehicleController;

@RestController
@RequestMapping("/api/lease-rate")
public class LeaseRate {

	@GetMapping("/{vehicleId}/{interestId}/{mileage}/{duration}")
	public Double calculateLeaseRate(@PathVariable long vehicleId,
	                                 @PathVariable long interestId,
	                                 @PathVariable int mileage,
	                                 @PathVariable int duration) {
		VehicleController vehicleController = new VehicleController();
		Vehicle vehicle = vehicleController.findVehicleById(vehicleId).getBody();
		InterestController interestController = new InterestController();
		Interest interest = interestController.findInterestById(interestId).getBody();
		if (interest != null && vehicle != null) {
			double nettPrice = vehicle.getNettPrice();
			return (((mileage / 12) * duration) / nettPrice) + (((interest.getInterestRate() / 100) * nettPrice) / 12);
		}
		return (double) Integer.MIN_VALUE;
	}
}
