package com.ig.producerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@GetMapping("/producerservice")
	public String getMessage() {
		return "producer Microservice";
	}

}
