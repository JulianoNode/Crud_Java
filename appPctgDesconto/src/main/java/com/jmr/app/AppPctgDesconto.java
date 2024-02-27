package com.jmr.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppPctgDesconto {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication app = new SpringApplication(AppPctgDesconto.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8089"));
		app.run(args);
		System.out.println(recursos.runProgeto());
		
		
	}

}
