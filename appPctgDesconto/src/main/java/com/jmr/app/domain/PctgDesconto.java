package com.jmr.app.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pctgDescontos", indexes = {@Index(name = "idx_pctgDesconto_pctgDesconto", 
											   columnList = "pctgDesconto")})
public class PctgDesconto extends AbstractEntity {
	
	@Column(name = "pctgDesconto", unique = true, nullable = false, length = 2)
	private int desconto;
	
	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}	

}
