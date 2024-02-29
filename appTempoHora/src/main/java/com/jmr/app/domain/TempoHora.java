package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tempoHoras", indexes = {@Index(name = "idx_tempoHora_titulo", columnList = "titulo")})
public class TempoHora extends AbstractEntity {
	
	@Column(name = "titulo", unique = true, nullable = false)
	private String titulo;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	


}
