package br.com.vvcurso.services;

import br.com.vvcurso.model.Pedido;

public interface Acao {

	public String incluir(Pedido pedido);
	public Object consultar();
	public void alterar();
	public void excluir();
	public void sair();
}
