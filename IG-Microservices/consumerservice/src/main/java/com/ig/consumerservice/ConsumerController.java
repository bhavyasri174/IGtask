package com.ig.consumerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/data")
	public String getProduct() {
		String response=restTemplate.getForObject("http://localhost:8081/producerservice", String.class);
		System.out.println("using respone"+response);
		return response;
		
	}
	
	
}
