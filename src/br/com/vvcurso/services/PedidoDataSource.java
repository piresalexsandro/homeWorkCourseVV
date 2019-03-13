package br.com.vvcurso.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.vvcurso.model.Item;
import br.com.vvcurso.model.Pedido;

public class PedidoDataSource implements Acao{

	Scanner sc = new Scanner(System.in);
    //Pedido[] pd = new Pedido[n];
    Pedido p = new Pedido();
    Item itemPedido;		
	Map<Object, String> mapPedidos = new HashMap<>();
	String desejaSair;
	
	
    public void acao(final String opcao) {
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
			alterar();
			break;
		case "S":
			sair();
			if (desejaSair == "S") {
				break;
			}else {
				return;
			}
		default:
			System.out.println("Opcao invalida");
			break;
		}
    }
    
	@Override
    public void incluir() {
		System.out.print("Codigo do Pedido: ");
		Integer codigoPedido = sc.nextInt();

		System.out.print("Nome do Cliente.: ");
		String nomeCliente = sc.next();

		System.out.print("Codigo da Filial: ");
		Integer codigoFilial = sc.nextInt();

		System.out.println();
		System.out.print("Defina a quantidade de itens do pedido: ");
		Integer qtdeI = sc.nextInt();
		
		// Lista de ItemPedido
		List<Item> listItemPedido = new ArrayList<Item>();
		for (int i = 0; i < qtdeI; i++) {
			System.out.print("	Codigo do Item....: ");
			Integer codigoItem = sc.nextInt();

			System.out.print("	Valor do Item.....: ");
			BigDecimal valorItem = sc.nextBigDecimal();

			System.out.print("	Quantidade do Item: ");
			Integer qtdeItem = sc.nextInt();
			
			//obtendo o valor total do item e o valor do pedido
			double vI = valorItem.doubleValue();
			valorTotalItem(vI, qtdeItem);
			
			System.out.print("	Descricao do Item.: ");
			String nomeItem = sc.next();
			System.out.println();
			
			// Instancia de ItemPedido
			Item itemPedido = new Item(codigoItem, valorItem, qtdeItem, nomeItem);
			// Adiciona ItemPedido na Lista
			listItemPedido.add(itemPedido);
			
			
			Date dataAtual = getPegaDataAtual();
			Pedido pedido = new Pedido(dataAtual, null, codigoPedido, nomeCliente, codigoFilial, listItemPedido);
			mapPedidos.put(pedido, "pedido");
			p = pedido;
		}
		System.out.println(p);
	}
	
	@Override
    public void consultar() {
		mapPedidos.containsKey(p.getCodigoPedido());
    }
	
	@Override
    public void excluir() {
		mapPedidos.remove(p.getCodigoPedido());
    }
	
	@Override
    public void alterar() {
		System.out.println("ATUALIZAR");
		// tratar data da alteração
    }
	
	@Override
    public void sair() {
		System.out.print("Realmente deseja sair da aplicação? ");
		String x = sc.next();
		desejaSair = x;
    }

	public void valorTotalItem(final Double valorItem, int qtdeItem) {
		double valorTotalItem = 0.00;
		valorTotalItem = valorItem * qtdeItem;
		valorPedido(valorTotalItem);
	}
	
	public Double valorPedido(final Double valorTotalItem) {
		Double valorTotalPedido = 0.00;
		return valorTotalPedido += valorTotalItem;
	}
	
	public Date getPegaDataAtual() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.getTime();
	}
	
}
