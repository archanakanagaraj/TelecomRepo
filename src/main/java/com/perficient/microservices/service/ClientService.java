package com.perficient.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.perficient.microservices.model.Client;

@FeignClient(name = "client-micro-service")
public interface ClientService {
	@PostMapping("/client/createUpdateClient")
    Client createClient(Client client);
	
	@GetMapping("/findByCompany/{company}")
    Client findByCompany(String company);
	

}
