package br.com.vvcurso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Console {
	
	Scanner sc = new Scanner(System.in);
    Pedido p = new Pedido();
    Item itemPedido;		

	public Pedido preencherDados() {

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

			System.out.print("	Descricao do Item.: ");
			String nomeItem = sc.next();
			System.out.println();
			// Instancia de ItemPedido
			Item itemPedido = new Item(codigoItem, valorItem, qtdeItem, nomeItem);
			// Adiciona ItemPedido na Lista
			listItemPedido.add(itemPedido);
			
			Date dataAtual = getPegaDataAtual();
			Pedido pedido = new Pedido(dataAtual, null, codigoPedido, nomeCliente, codigoFilial, listItemPedido);

			//obtendo o valor total do item e o valor do pedido
			itemPedido.valorTotalItem(valorItem, qtdeItem);
			pedido.valorPedido(itemPedido.getValorItem());
			
			p = pedido;
		}
	//System.out.println(p);
	System.out.println();
	return p;	
	}
	
	public Date getPegaDataAtual() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.getTime();
	}
	
}

