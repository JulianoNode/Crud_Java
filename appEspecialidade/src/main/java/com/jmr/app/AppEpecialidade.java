package com.jmr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEpecialidade {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication.run(AppEpecialidade.class, args);
		
		System.out.println(recursos.runProgeto());
		
		
	}

}
