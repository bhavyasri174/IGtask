package com.ig.consumerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired 
		DiscoveryClient discoveryClient;
	 

	@GetMapping("/consumer") //white label 
	public String getMesssage() {
		String msg=restTemplate.getForObject("http://localhost:8081/producer", String.class);
		return   "Message from Producer :" + msg; //   "Consumer MEssage";
	}
    
   //need to comment method in producer 
   @GetMapping("/data1")
   @Retry(name="producer", fallbackMethod="sendDummyData")
   	@CircuitBreaker(name="producer", fallbackMethod="sendDummyData")
      	 public String getCources() {                  // http://localhost:8083/data1
            List<ServiceInstance> siList = discoveryClient.getInstances("PRODUCERAPP");
            ServiceInstance si = siList.get(0);
             String url = si.getUri() +"/producer";
            RestTemplate rt = new RestTemplate();
          String response = rt.getForObject(url, String.class);
           System.out.println("using discovery client"+ response);
             return response;
       }

   	public String sendDummyData(Exception e) {
   		return "Producer is unvailable,please go for other option";
   	}
   }

	