package br.com.vvcurso.services;

import br.com.vvcurso.model.Pedido;

public class PedidoDataSource {

	
    public void acao(final String opcao) {
        Pedido pedido = new Pedido();
		switch (opcao) {
		case "C":
			consultar();
			break;
		case "I":
			incluir();
			break;
		case "E":
			excluir();
			break;
		case "A":
			atualizar();
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("Opcao invalida");
		}
    	
    }
    
    public void consultar() {
		System.out.println("CONSULTAR");
    }
	
    public void incluir() {
		System.out.println("INCLUIR");
    }
	
    public void excluir() {
		System.out.println("EXCLUIR");
    }
	
    public void atualizar() {
		System.out.println("ATUALIZAR");
    }
	
    public void sair() {
		System.out.println("SAIR");
    }
	
}
