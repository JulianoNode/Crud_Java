package com.jmr.app;

import java.text.NumberFormat;
import java.util.Locale;

public class Tabelas {
	
	public String runProgeto () {
		
		System.out.println(runCategoria() 
						 + runPrivacidade() 
						 + runEspecialidade() 
						 + runGenero()
						 + runFormato()	
						 						 
						 + runFornecedor()
						 + runParcela()
						 + runProduto()
						 + runValorParcela()
						 + runImagem()
						 
						 + runAutor()
						 + runDia() 
						 + runMes() 
						 + runAno()
						 + runFormat()
						 );
		return "" ;
	}
	
	public String runCategoria () {
		return "\n\t|_ Progeto Categoria: nome/descrição " ;
	}
	
	public String runPrivacidade () {
		return "\n\t|_ Progeto Privacidade: titulo/descrição " ;
	}
	
	
	public String runEspecialidade () {
		return "\n\t|_ Progeto Especialidade: titulo/descrição " ;
	}
	
	public String runGenero () {
		return "\n\t|_ Progeto Genero: titulo/descrição " ;
	}
	
	public String runFormato () {
		return "\n\t|_ Progeto Formato: Titulo \n" ;
	}	
	
	public String runAutor () {
		return "\n\t|_ Progeto Autor: nome/idade " ;
	}
	
	
	public String runFornecedor () {
		return "\n\t|_ Progeto Fornecedor: nome/link " ;
	}
	
	public String runParcela () {
		return "\n\t|_ Progeto Parcela: parcela " ;
	}
	
	public String runProduto () {
		return "\n\t|_ Progeto Produto: link/titulo/imagem " ;
	}
	
	public String runValorParcela () {
		return "\n\t|_ Progeto ValorParcela: valor" ;
	}
	
	public String runImagem () {
		return "\n\t|_ Progeto Imagem: nome/foto \n" ;
	}
	
	public String runDia () {
		return "\n\t|_ Progeto Dia: dia" ;
	}
	public String runMes () {
		return "\n\t|_ Progeto Mes: mes" ;
	}
	public String runAno () {
		return "\n\t|_ Progeto Ano: ano" ;
	}
	
	public String runFormat ()  { 
		
		Locale localeBR = new Locale("pt","BR");

	double valorReal = 291933.1233;
	float valorPercentual = 0.11f;
	int valorInteiro = 82819912;

		NumberFormat inteiro = NumberFormat.getInstance();  
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
		NumberFormat percentual = NumberFormat.getPercentInstance(localeBR);
		NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);

		System.out.println("\n\nt|_Valor Atual: "+valorReal);
		System.out.println("\nt|_Valor Formatado em Moeda: "+dinheiro.format(valorReal));
		
		System.out.println("\nt|_Valor Atual: "+valorPercentual);
		System.out.println("\nt|_Valor Formatado em Percentual: "+percentual.format(valorPercentual));
		
		System.out.println("\nt|_Valor Atual: "+valorInteiro);
		System.out.println("\nt|_Valor Formatado: "+inteiro.format(valorInteiro));
		
		System.out.println("\nt|_Valor Atual: "+valorReal);
		System.out.println("\nt|_Valor Formatado padrão: "+numberFormat.format(valorReal));
		
		return "\n\t|_ Progeto Ano: ano" ;

	}
	
	
	


}
