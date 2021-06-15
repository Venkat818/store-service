package com.walmart.store.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.store.entity.StoreDetail;
import com.walmart.store.model.StoreRequest;
import com.walmart.store.repository.StoreDetailRepository;
import com.walmart.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDetailRepository storeDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StoreDetail saveStoreInfo(final StoreRequest storeRequestDTO) {
		StoreDetail storeDetail=modelMapper.map(storeRequestDTO, StoreDetail.class);
		return storeDetailRepository.save(storeDetail);
	}
}
