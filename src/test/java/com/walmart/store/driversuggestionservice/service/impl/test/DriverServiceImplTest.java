package com.walmart.store.driversuggestionservice.service.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.store.entity.DriverDetail;
import com.walmart.store.entity.StoreDetail;
import com.walmart.store.model.DriverDetails;
import com.walmart.store.repository.DriverDetailRepository;
import com.walmart.store.repository.StoreDetailRepository;
import com.walmart.store.service.impl.DriverServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceImplTest {

	@InjectMocks
	private  DriverServiceImpl  driverServiceImpl;

    @Mock
    private DriverDetailRepository driverDetailRepository;
    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private StoreDetailRepository storeDetailRepository;
    @Mock
    private ObjectMapper mapper;

    private DriverDetail driverDetail;
    private List<DriverDetail> driverDetails;
    private DriverDetails driverDetailsDTO;
    private StoreDetail storeDetail;
    
    

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        driverDetail=new DriverDetail("1", 1.0, 1.9);
        driverDetailsDTO=new DriverDetails("1", 1.0, 1.9);
        storeDetail=new StoreDetail("1", 1.0, 1.9);
        driverDetails=new ArrayList();
        driverDetails.add(driverDetail);
    }
    

    @Test
    public void testSaveStoreInfo() {
    	driverServiceImpl.saveDriverDetails(driverDetail);
    }

    @Test
    public void testPublishToKafka() {
    	driverServiceImpl.publishToKafka(driverDetailsDTO);
    }

    @Test
    public void testPublishToKafkaException() throws JsonProcessingException {
        Mockito.when(mapper.writeValueAsString(Mockito.any(DriverDetails.class))).thenThrow(JsonProcessingException.class);
    	driverServiceImpl.publishToKafka(driverDetailsDTO);
    }
    
    @Test
    public void testGetNearestNDrivers() throws Exception {
        Mockito.when(storeDetailRepository.findById(Mockito.anyString())).thenReturn(Optional.of(storeDetail));
       Mockito.when(driverDetailRepository.getNearestStore(Mockito.any(),
    		   Mockito.any(), Mockito.any())).thenReturn(driverDetails);
        Assert.assertNotNull(driverServiceImpl.getNearestNDrivers("1", 1));
    }

}
