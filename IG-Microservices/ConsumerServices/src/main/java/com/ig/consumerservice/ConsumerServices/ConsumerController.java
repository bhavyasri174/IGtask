package com.ig.consumerservice.ConsumerServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;


@RestController
public class ConsumerController {

	@Autowired(required=true)
	DiscoveryClient discoveryClient;
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/data")
	   public String getProduct() {                  
	    	List<ServiceInstance> siList = discoveryClient.getInstances("PRODUCERSERVICE");
	    	ServiceInstance si = siList.get(0);
	         
	            String url =  si.getUri() +"/producerservice";
	         String response = restTemplate.getForObject(url, String.class);
	          System.out.println("using discovery client"+ response);
	            return response;
	      }
}