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

	private Integer codigoPedido;
	private String nomeCliente;
	private Integer codigoFilial;
	private Integer codigoItem;
	private BigDecimal valorItem;
	private Integer qtdeItem;
	private String nomeItem;
	
	public Item getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(Item itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getCodigoFilial() {
		return codigoFilial;
	}

	public void setCodigoFilial(Integer codigoFilial) {
		this.codigoFilial = codigoFilial;
	}

	public Integer getCodigoItem() {
		return codigoItem;
	}
	
	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public Integer getQtdeItem() {
		return qtdeItem;
	}

	public void setQtdeItem(Integer qtdeItem) {
		this.qtdeItem = qtdeItem;
	}

	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	
	public Pedido retornarPedido(Pedido pedido) {

		System.out.println("Altere os dados necessarios");
		System.out.println("Data Inclusao...: " + pedido.getDataHoraInclusao());
		Date dataAlteracao = getPegaDataAtual();
		pedido.setDataHoraAlteracao(dataAlteracao);
		System.out.println("Data Alteracao..: " + pedido.getDataHoraAlteracao());
		System.out.println("Codigo do Pedido: " + pedido.getCodigoPedido());
		System.out.println("Nome do Cliente.: " + pedido.getNomeCliente());
		System.out.println("Codigo da Filial: " + pedido.getCodigoFilial());
		System.out.println("*-------------- I T E N S --------------*");
		for (Item itemPedido : pedido.getItens()) {
			System.out.println("	Codigo do Item....: " + itemPedido.getCodigoItem());
			System.out.println("	Valor do Item.....: " + itemPedido.getValorItem());
			System.out.println("	Quantidade do Item: " + itemPedido.getQtdeItem());
			System.out.println("	Descricao do Item.: " + itemPedido.getNomeItem());
		}
		p = pedido;
		return p;
	}
	
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

