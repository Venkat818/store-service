package com.walmart.store.driversuggestionservice.service.impl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.walmart.store.entity.StoreDetail;
import com.walmart.store.model.StoreRequest;
import com.walmart.store.repository.StoreDetailRepository;
import com.walmart.store.service.impl.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {


	@InjectMocks
	private StoreServiceImpl storeServiceImpl;

    @Mock
    private StoreDetailRepository storeDetailRepository;
    @Mock
    private ModelMapper modelMapper;

    private StoreRequest storeRequestDTO; 
    private StoreDetail storeDetail;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
		storeRequestDTO = new StoreRequest("1", 1.2, 2.4);
		storeDetail = new StoreDetail("1", 1.2, 2.4);

    }
    
    
    @Test
    public void testSaveStoreInfo() {
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(storeDetail);
        Mockito.when(storeDetailRepository.save(Mockito.any())).thenReturn(storeDetail);
    	StoreDetail storeDetailObj=storeServiceImpl.saveStoreInfo((storeRequestDTO));
    	Assert.assertNotNull(storeDetailObj);
    }
    
}
