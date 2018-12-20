package com.perficient.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.perficient.microservices.model.Client;
import com.perficient.microservices.service.ClientService;
import com.perficient.microservices.service.KafkaService;

import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private KafkaService kafkaService;

	/*@SuppressWarnings("unused")
	private Client defaultCreateClient(@RequestBody Client client) {
		// TODO : Redirect to home page
		return client;
	}*/

	//@SuppressWarnings("unused")
	@PostMapping(value = "/createUpdateClient", produces = "application/json")
	//@HystrixCommand(fallbackMethod = "defaultCreateClient")
	@ApiOperation(value = "Create Client", notes = "Create Client")
	public Client createClient(@RequestBody Client client) {
		System.out.println("Inside Controller - createClient");
		Client client1 = clientService.createClient(client);
		System.out.println("Client Details returned for :"+ client1.getName() + " - " + client1.getCompany());
		return client1;
	}
	
	//@SuppressWarnings("unused")
	@GetMapping(value = "/findByCompany/{company}", produces = "application/json")
	//@HystrixCommand(fallbackMethod = "defaultCreateClient")
	@ApiOperation(value = "Search Client",
    notes = "Search client based on the company name")
	public Client findByCompany(@PathVariable("company") String company) {
		System.out.println("Inside Controller - findByCompany: "+ company);
		Client client1 = clientService.findByCompany(company);
		return client1;
	}
	
	//@SuppressWarnings("unused")
	@PutMapping(value = "/updateStatus")
	//@HystrixCommand(fallbackMethod = "defaultCreateClient")
	@ApiOperation(value = "Activate/ Deactivate Client",
    notes = "Used to Activate or Deactivate the Client status")
	public void updateClientStatus(@RequestBody Client client) {
		System.out.println("Inside Controller - updateStatus: "+ client.getStatus());
		kafkaService.updateClientStatus(client);
		
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public KafkaService getKafkaService() {
		return kafkaService;
	}

	public void setKafkaService(KafkaService kafkaService) {
		this.kafkaService = kafkaService;
	}
	
	
	
}
