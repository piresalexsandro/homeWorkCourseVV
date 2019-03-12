package br.com.vvcurso.application;

import java.util.Scanner;

import br.com.vvcurso.services.PedidoDataSource;

public class Program {

	public static void main(String[] args) {

	   	Scanner sc = new Scanner(System.in);
        System.out.println(); 
		PedidoDataSource pds = new PedidoDataSource();
		String acao = sc.next();
		pds.acao(acao);
	}

}
