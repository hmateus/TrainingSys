package br.com.service;

import java.io.Serializable;
import java.util.List;

import br.com.DAO.EnderecoDAO;
import br.com.model.Entidade;

public class EnderecoService implements AbstratoService<Entidade>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2829566649962192320L;
	
	private EnderecoDAO enderecoDao;
	
	@Override
	public void salvar(Entidade entidade) {
		enderecoDao.salvar(entidade);
	}

	@Override
	public void editar(Entidade entidade) {
		enderecoDao.editar(entidade);
	}

	@Override
	public void excluir(Long id) {
		enderecoDao.excluir(id);
	}

	@Override
	public void excluir(Entidade entidade) {
		enderecoDao.excluir(entidade);
	}

	@Override
	public Entidade buscar(Long id) {
		return enderecoDao.buscar(id);
	}

	@Override
	public List<Entidade> listar() {
		return enderecoDao.listar();
	}

}
