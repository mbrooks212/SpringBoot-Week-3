package com.promineotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.promineo.jeep.dao","com.promineotech","com.promineotech.jeep.controller","com.promineotech.jeep.entity",
		"com.promineotech.jeep.service"})
public class JeepSaleApplication {
	public static void main(String[] args) {
		 SpringApplication.run(JeepSaleApplication.class, args);
			
	}

}
