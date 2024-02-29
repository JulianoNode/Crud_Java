package com.jmr.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppCategoria {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication app = new SpringApplication(AppCategoria.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		app.run(args);
		System.out.println(recursos.runProgeto());
		
		
	}

}
