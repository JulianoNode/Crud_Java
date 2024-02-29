package com.jmr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDia {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
		
		SpringApplication.run(AppDia.class, args);
		
		System.out.println(recursos.runProgeto());
		
		
	}

}
