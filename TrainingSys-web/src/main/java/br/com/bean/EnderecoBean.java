package br.com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.model.Entidade;
import br.com.service.EnderecoService;

@ManagedBean
@ViewScoped
public class EnderecoBean implements AbstratoBean<Entidade>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5819162517605492775L;

	@Inject
	EnderecoService service;

	@Override
	public String salvar() {
		return null;
	}

	@Override
	public String editar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararEdicao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarView() {
		// TODO Auto-generated method stub

	}

	@Override
	public String excluir(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visualizar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisualizar() {
		// TODO Auto-generated method stub
		return false;
	}

}
