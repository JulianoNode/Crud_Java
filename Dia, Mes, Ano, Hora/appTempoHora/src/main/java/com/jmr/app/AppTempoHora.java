package com.jmr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTempoHora {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication.run(AppTempoHora.class, args);
		
		System.out.println(recursos.runProgeto());
		
		
	}

}
