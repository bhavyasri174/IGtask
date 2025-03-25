package com.ig.producerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerserviceApplication.class, args);
	}

}
