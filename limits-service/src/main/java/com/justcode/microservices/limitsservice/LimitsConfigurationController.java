package com.justcode.microservices.limitsservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justcode.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;


	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(), 
				configuration.getMinimum());
		return limitConfiguration;
	}
	
	@GetMapping("/fault-tolerence-example")
	@HystrixCommand(fallbackMethod="fallbackretrieveConfigurations")
	public LimitConfiguration retrieveConfigurations() {
		throw new RuntimeException();
	}

public LimitConfiguration fallbackretrieveConfigurations(){
	return new LimitConfiguration(888, 8);
}
}
