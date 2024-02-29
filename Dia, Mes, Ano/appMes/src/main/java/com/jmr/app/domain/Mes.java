package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "meses", indexes = {@Index(name = "idx_mes_nome", columnList = "nome")})
public class Mes extends AbstractEntity {
	
	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
