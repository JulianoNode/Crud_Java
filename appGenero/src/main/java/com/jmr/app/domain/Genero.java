package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "generos", indexes = {@Index(name = "idx_genero_genero", columnList = "genero")})
public class Genero extends AbstractEntity {
	
	@Column(name = "genero", unique = true, nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
