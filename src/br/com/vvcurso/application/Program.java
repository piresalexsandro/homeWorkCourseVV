package br.com.vvcurso.application;

import java.util.Locale;
import java.util.Scanner;

import br.com.vvcurso.services.PedidoDataSource;

public class Program {

	public static void main(String[] args) {
		
		boolean exit = false;
		Locale.setDefault(Locale.US);
	   	Scanner sc = new Scanner(System.in);
		PedidoDataSource pds = new PedidoDataSource();
		
		while (!exit) {
			System.out.println("A - Alterar \nC - Consultar \nI - Inseir \nE - Excluir \nS - Sair");
			System.out.println();
			System.out.print("Digite a a��o desejada: ");
			String acao = sc.next();
			exit = pds.acao(acao);
		}
	}
}
