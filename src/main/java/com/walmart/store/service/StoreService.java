package com.walmart.store.service;

import com.walmart.store.entity.StoreDetail;
import com.walmart.store.model.StoreRequest;

public interface StoreService {

	 StoreDetail saveStoreInfo(final StoreRequest storeRequestDTO);
}
