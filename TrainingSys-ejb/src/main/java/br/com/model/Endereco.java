package br.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 889819419495113799L;

	@Column(length = 15, nullable = false)
	private String cep;

	@Column(length = 50)
	private String rua;

	@Column
	private int numero;

	@Column
	private String complemento;

	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 50, nullable = false)
	private String cidade;

	@Column(length = 2, nullable = false)
	private String uf;

	// GETERS & SETERS
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
