package com.walmart.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.store.entity.StoreDetail;
import com.walmart.store.model.StoreRequest;
import com.walmart.store.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping
	public StoreDetail saveStoreInfo(@RequestBody StoreRequest storeRequestDTO) {
		return storeService.saveStoreInfo(storeRequestDTO);
	}

}
