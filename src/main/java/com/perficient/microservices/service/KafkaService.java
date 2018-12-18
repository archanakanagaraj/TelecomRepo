package com.perficient.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.perficient.microservices.model.Client;

@FeignClient(name = "kafka-producer")
public interface KafkaService {
	@PostMapping("/kafka/updateProducer")
    void updateClientStatus(Client client);
}
