package com.perficient.microservices.controller.test;

import com.perficient.microservices.controller.ClientController;
import com.perficient.microservices.model.*;
import com.perficient.microservices.model.Client.ClientStatus;
import com.perficient.microservices.service.ClientService;
import com.perficient.microservices.service.KafkaService;

import static org.junit.Assert.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientControllerTest {
	
	@Autowired
	static Client client;	
	
	@Mock
	ClientService clientService;
	
	ClientController clientController = new ClientController();
	
	@Mock
	KafkaService kafkaService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		client = new Client();
		client.setName("John");
		client.setCompany("Perficient");
		client.setEmail("john@perficient.com");
		client.setStatus(ClientStatus.A);		
			
	}

	

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(clientService.createClient(client)).thenReturn(client);
		
		Mockito.when(clientService.findByCompany("Perficient")).thenReturn(client);
		
		clientController.setClientService(clientService);
		
	}

	

	@Test
	public void testCreateClient() {			
		assertNotNull(clientController.createClient(client));
		assertEquals("John", clientController.createClient(client).getName());
		assertEquals("Perficient", clientController.createClient(client).getCompany());		
	}

	@Test
	public void testFindByCompany() {		
		assertNotNull(clientController.findByCompany("Perficient"));		
		assertEquals("Perficient", clientController.findByCompany("Perficient").getCompany());			
	}

	@Test
	public void testUpdateClientStatus() {
		
		Client toBeDeactiveClient = new Client();		
		toBeDeactiveClient.setName("Mary");
		toBeDeactiveClient.setCompany("Perficient");
		toBeDeactiveClient.setStatus(ClientStatus.D);				
		
		clientController.setKafkaService(kafkaService);
		
		clientController.updateClientStatus(toBeDeactiveClient);
		
		assertEquals(ClientStatus.D , toBeDeactiveClient.getStatus());
		
	}

}
;