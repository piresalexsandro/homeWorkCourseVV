package br.com.vvcurso.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.vvcurso.model.Console;
import br.com.vvcurso.model.Pedido;

public class PedidoDataSource implements Acao {

	Scanner sc = new Scanner(System.in);
	Pedido p = new Pedido();
	Console console = new Console();
	Map<Integer, Object> mapPedidos = new HashMap<>();
	String desejaSair;

	public boolean acao(final String opcao) {
		switch (opcao.toUpperCase()) {
		case "C":
			consultar();
			break;
		case "I":
			console.preencherDados();
			String retorno = incluir(p);
			System.out.println(retorno);
			break;
		case "E":
			excluir();
			break;
		case "A":
			alterar();
			break;
		case "S":
			sair();
			if (desejaSair == "S") {
				return true;
			}
			break;
		default:
			System.out.println("Opcao invalida");
			break;
		}

		return false;
	}

	@Override
	public String incluir(Pedido pedido) {
		mapPedidos.put(pedido.getCodigoPedido(), pedido);
		return "Pedido incluido com sucesso";
	}

	@Override
	public Object consultar() {
		System.out.print("Entre com o codigo do pedido a ser consultado: ");
		int cdPedido = sc.nextInt();
		p.setCodigoPedido(cdPedido); 
		return mapPedidos.getOrDefault(p.getCodigoPedido(), null);
	}

	@Override
	public void excluir() {
		System.out.print("Entre com o codigo do pedido a ser excluido: ");
		int cdPedido = sc.nextInt();
		p.setCodigoPedido(cdPedido); 
		mapPedidos.remove(p.getCodigoPedido());
	}

	@Override
	public void alterar() {

		if (mapPedidos.containsKey(p.getCodigoPedido())) {
			mapPedidos.put(p.getCodigoPedido(), new Object());
		} else {
			System.out.println("Pedido não encontrado! Deseja incluir?");
			this.incluir(p);
		}

		// tratar data da alteração
	}

	@Override
	public void sair() {
		System.out.print("Realmente deseja sair da aplicação? ");
		String x = sc.next();
		desejaSair = x;
	}
}
