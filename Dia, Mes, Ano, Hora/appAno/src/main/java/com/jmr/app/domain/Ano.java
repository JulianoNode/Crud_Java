package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "anos", indexes = {@Index(name = "idx_ano_ano", columnList = "ano")})
public class Ano extends AbstractEntity {
	
	@Column(name = "ano", unique = true, nullable = false)
	private String ano;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	

}
