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
	int cdPedido;
	
	public boolean acao(final String opcao) {
		switch (opcao.toUpperCase()) {
		case "C":
			System.out.print("Entre com o codigo do pedido a ser consultado: ");
			cdPedido = sc.nextInt();
			p = consultar(cdPedido);
			System.out.println(p);
			break;
		case "I":
			String retorno = incluir(p = console.preencherDados());
			System.out.println(retorno);
			break;
		case "E":
			System.out.print("Entre com o codigo do pedido a ser excluido: ");
			cdPedido = sc.nextInt();
			excluir(cdPedido);
			break;
		case "A":
			System.out.print("Entre com o codigo do pedido a ser alterado: ");
			cdPedido = sc.nextInt();
			alterar(cdPedido);
			break;
		case "S":
			sair();
			if (desejaSair.toUpperCase().equals("S")) {
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
		System.out.println("mapPedidos " + mapPedidos);
		return "Pedido incluido com sucesso";
	}

	@Override
	public Pedido consultar(final int cdPedidoConsultar) {
		System.out.println();
		Pedido retornoConsulta = new Pedido();
		retornoConsulta.setCodigoPedido(cdPedidoConsultar); 
		retornoConsulta = (Pedido) mapPedidos.getOrDefault(retornoConsulta.getCodigoPedido(), null);
		return retornoConsulta;
	}
	
	@Override
	public void excluir(int cdPedidoExcluir) {
		Pedido pedidoExcluir = new Pedido();
		pedidoExcluir.setCodigoPedido(cdPedidoExcluir); 
		
		if (mapPedidos.containsKey(cdPedido)) {
			pedidoExcluir = consultar(cdPedido);
			console.retornarPedido(pedidoExcluir);
			mapPedidos.put(pedidoExcluir.getCodigoPedido(), new Object());
		} else {
			System.out.println("Pedido não encontrado! Deseja incluir?");
			this.incluir(pedidoExcluir);
		}
		mapPedidos.remove(p.getCodigoPedido());
		System.out.println("Pedido: "+ cdPedido + ", excluido com sucesso");
	}

	@Override
	public void alterar(int cdPedidoAlterar) {

		Pedido retornoPedidoAlterar = new Pedido();

		if (mapPedidos.containsKey(cdPedidoAlterar)) {
			retornoPedidoAlterar = consultar(cdPedidoAlterar);
			console.retornarPedido(retornoPedidoAlterar);
			mapPedidos.put(retornoPedidoAlterar.getCodigoPedido(), new Object());
		} else {
			System.out.println("Pedido não encontrado! Deseja incluir?");
			this.incluir(retornoPedidoAlterar);
		}
		
	}

	@Override
	public void sair() {
		System.out.println();
		System.out.print("Realmente deseja sair da aplicação? ");
		String x = sc.next();
		desejaSair = x;
	}
}