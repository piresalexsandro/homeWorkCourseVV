package br.com.vvcurso.application;

import java.util.Scanner;

import br.com.vvcurso.services.PedidoDataSource;

public class Program {

	public static void main(String[] args) {

		PedidoDataSource pds = new PedidoDataSource();
		
	   	Scanner sc = new Scanner(System.in);
	    
	   	System.out.print("Entre com a ação desejada: ");
		String acao = sc.next();
		pds.acao(acao);
	}

}
