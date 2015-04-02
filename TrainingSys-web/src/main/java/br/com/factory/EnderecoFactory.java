package br.com.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.google.common.base.Strings;

import br.com.model.Endereco;
import br.com.service.EnderecoService;

public class EnderecoFactory {

	@Inject
	EnderecoService service;

	@Produces
	public Endereco produzir() {
		Endereco endereco = new Endereco();
		String id = endereco.getId().toString();
		if (!Strings.isNullOrEmpty(id)) {
			Long idL = new Long(id);
			service.buscar(idL);
		}
		return endereco;
	}
}
