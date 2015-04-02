package br.com.service;

import java.util.List;

import br.com.model.Entidade;

public interface AbstratoService<T extends Entidade> {
	public void salvar(T entidade);
	public void editar(T entidade);
	public void excluir(Long id);
	public void excluir(T entidade);
	public T buscar(Long id);
	public List<T> listar();
	
}
