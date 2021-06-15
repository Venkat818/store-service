package com.walmart.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.store.entity.DriverDetail;
import com.walmart.store.model.DriverDetails;
import com.walmart.store.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired 
	private DriverService driverService;
	
	@GetMapping("nearest")
	public List<DriverDetail> getNearestNDrivers(@RequestParam("storeId") String storeId, 
			@RequestParam("N") Integer numberOfDrivers) throws Exception {
		return driverService.getNearestNDrivers(storeId, numberOfDrivers);
	}
	
	@PostMapping("location")
	public void publishToKafka(@RequestBody DriverDetails driverDetailsDTO) {
		driverService.publishToKafka(driverDetailsDTO);
	}
}
