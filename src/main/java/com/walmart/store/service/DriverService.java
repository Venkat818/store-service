package com.walmart.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.store.entity.DriverDetail;
import com.walmart.store.model.DriverDetails;

@Service
public interface DriverService {

	public void publishToKafka(final DriverDetails driverDetailsDTO);
	 List<DriverDetail> getNearestNDrivers(final String storeId, final Integer numberOfDrivers) throws Exception;
	 
	 public void saveDriverDetails(DriverDetail driverDetail);
}
