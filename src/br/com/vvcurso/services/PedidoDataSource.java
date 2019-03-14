package br.com.vvcurso.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.vvcurso.model.Console;
import br.com.vvcurso.model.Pedido;

public class PedidoDataSource implements Acao {

	Scanner sc = new Scanner(System.in);
	Pedido p = new Pedido();
	Map<Integer, Object> mapPedidos = new HashMap<>();
	String desejaSair;

	public boolean acao(final String opcao) {
		switch (opcao.toUpperCase()) {
		case "C":
			System.out.print("Entre com o codigo do pedido a ser consultado: ");
			p = consultar();
			System.out.println(p);
			break;
		case "I":
			Console console = new Console();
			String retorno = incluir(p = console.preencherDados());
			System.out.println(retorno);
			break;
		case "E":
			excluir();
			//System.out.println(mapPedidos);
			break;
		case "A":
			alterar();
			//System.out.println(mapPedidos);
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
	public Pedido consultar() {
		int cdPedido = sc.nextInt();
		//p.setCodigoPedido(cdPedido); 
		System.out.println();
		//Pedido retornoConsulta = new HashMap<>();
		Pedido retornoConsulta = new Pedido();
		retornoConsulta = (Pedido) mapPedidos.getOrDefault(cdPedido, null);
		return retornoConsulta;
	}
	
	@Override
	public void excluir() {
		System.out.print("Entre com o codigo do pedido a ser excluido: ");
		int cdPedido = sc.nextInt();
		p.setCodigoPedido(cdPedido); 
		mapPedidos.remove(p.getCodigoPedido());
		System.out.println("Pedido: "+ cdPedido + ", excluido com sucesso");
		System.out.println();
	}

	@Override
	public void alterar() {

		System.out.println();
		System.out.print("Entre com o codigo do pedido a ser alterado: ");
		int cdPedido = sc.nextInt();
		//p = (Pedido) mapPedidos.get(cdPedido);
		p.setCodigoPedido(cdPedido);
		p = consultar();
		
		
		
		if (mapPedidos.containsKey(p.getCodigoPedido())) {
			mapPedidos.put(p.getCodigoPedido(), new Object());
		} else {
			System.out.println("Pedido não encontrado! Deseja incluir?");
			this.incluir(p);
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
