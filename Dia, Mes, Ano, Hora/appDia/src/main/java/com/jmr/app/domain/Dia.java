package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "dias", indexes = {@Index(name = "idx_dia_dia", columnList = "dia")})
public class Dia extends AbstractEntity {
	
	@Column(name = "dia", unique = true, nullable = false)
	private String dia;

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}
