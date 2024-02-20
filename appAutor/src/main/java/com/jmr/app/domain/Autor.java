package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "autores", indexes = {@Index(name = "idx_autor_nome", columnList = "nome")})
public class Autor extends AbstractEntity {
	
	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "idade", nullable = false)
	private String idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	

}
