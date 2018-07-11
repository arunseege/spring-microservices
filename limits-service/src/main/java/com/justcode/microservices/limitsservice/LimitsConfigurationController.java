package com.justcode.microservices.limitsservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justcode.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {



	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(10,1000);
		return limitConfiguration;
	}
	


}
