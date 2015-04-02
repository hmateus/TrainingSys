package br.com.bean;

import br.com.model.Entidade;

public interface AbstratoBean<T extends Entidade> {

	public String salvar();
	
	public String editar();
	
	public String prepararEdicao();
	
	public void atualizarView();
	
	public String excluir(T entidade);
	
	public String visualizar();
	
	public boolean isVisualizar();
}
