package com.api.rest;

import com.api.rest.domain.MedallaService;
import com.api.rest.services.AtletaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(ApiRestApplication.class, args);

		context.getBean(AtletaService.class).testAtleta();
		context.getBean(MedallaService.class).setMedallas();



	}


}
