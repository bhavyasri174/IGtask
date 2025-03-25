package com.ig.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consumer")
	public String consume() {
		ResponseEntity<String> resource=
				restTemplate.getForEntity("http://localhost:8081/producer", String.class);
		return resource.getBody().toString();	
	}

}
