package com.jmr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppAutor {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication.run(AppAutor.class, args);
		
		System.out.println(recursos.runProgeto());
		
		
	}

}
