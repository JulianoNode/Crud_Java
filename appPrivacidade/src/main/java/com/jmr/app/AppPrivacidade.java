package com.jmr.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppPrivacidade {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();

		SpringApplication app = new SpringApplication(AppPrivacidade.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);

		System.out.println(recursos.runProgeto());

	}

}
