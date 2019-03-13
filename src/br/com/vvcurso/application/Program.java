package br.com.vvcurso.application;

import java.util.Locale;
import java.util.Scanner;

import br.com.vvcurso.services.PedidoDataSource;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
	   	Scanner sc = new Scanner(System.in);
		PedidoDataSource pds = new PedidoDataSource();
		
		System.out.println("A - Alterar \nC - Consultar \nI -Inseir \nE - Excluir \nS - Sair");
		System.out.println();
		System.out.print("Digite a ação desejada: ");
		String acao = sc.next();
		pds.acao(acao);
	}

}
