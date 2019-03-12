package br.com.vvcurso.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.vvcurso.model.Item;
import br.com.vvcurso.model.Pedido;

public class PedidoDataSource implements Acao{

	Scanner sc = new Scanner(System.in);
    Pedido pedido = new Pedido();
    Item itemPedido;		
	Map<Integer, String> mapPedidos = new HashMap<>();
	String desejaSair;
	
	public PedidoDataSource() {
	}
	
	public PedidoDataSource(Pedido pedido) {
	}

    public void acao(final String opcao) {
		switch (opcao) {
		case "C":
			consultar();
		case "I":
			incluir();
		case "E":
			excluir();
		case "A":
			alterar();
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
    public void consultar() {
		mapPedidos.containsKey(pedido.getCodigoPedido());
    }
	
	@Override
    public void incluir() {

    	int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        Pedido[] pd = new Pedido[n];

	   	System.out.print("Quantos pedidos voce quer inserir: ");
        for(int i=1; i<pd.length; i++){ 
			System.out.println("Pedido numero #" + i + ": ");
			System.out.print("Codigo do Pedido: ");
			Integer codigoPedido = sc.nextInt();
			
			System.out.print("Nome do Cliente: ");
			String nomeCliente = sc.next();
			
			System.out.print("Codigo da Filial: ");
			Integer codigoFilial = sc.nextInt();
			
		   	System.out.print("Defina a quantidade de itens do pedido.");
	        Integer qtdeI = sc.nextInt();
	        double[] vect = new double[qtdeI];
	        for(int j=1; j<vect.length; j++){ 
				System.out.print("Codigo do Item: ");
				Integer codigoItem = sc.nextInt();
				
				System.out.print("Valor do Item: ");
				BigDecimal valorItem = sc.nextBigDecimal();
				
				System.out.print("Quantidade do Item: ");
				Integer qtdeItem = sc.nextInt();
				
				System.out.print("Descricao do Item: ");
				String nomeItem = sc.next();
				new Item(codigoItem, valorItem, qtdeItem, nomeItem);
				pd[i].addItemPedido(itemPedido);
	        }
	        
			pd[i] = new Pedido(dataAtual, null, codigoPedido, nomeCliente, codigoFilial, ArrayList<itemPedido> list);
			mapPedidos.put(pd[i].getCodigoPedido(), "pedido");
        } 
    }
	
	@Override
    public void excluir() {
		mapPedidos.remove(pedido.getCodigoPedido());
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

}
