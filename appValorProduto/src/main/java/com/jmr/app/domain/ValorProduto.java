package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "valorProdutos", indexes = {@Index(name = "idx_valorProduto_valor_da_produto", columnList = "valor_da_produto")})
public class ValorProduto extends AbstractEntity {
	
	@Column(name = "valor_da_produto", unique = true, nullable = false, length = 12)

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}



}
