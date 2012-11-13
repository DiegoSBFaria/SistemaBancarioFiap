package br.com.fiap.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.TransacaoDAO;
import br.com.fiap.model.Pessoa;

@ManagedBean

public class TransacaoController implements Controller {
	private Integer agencia;
	private Integer conta;
	private Integer digito;
	private Integer senha;
	private Pessoa pessoa;
	private Integer valor;
	
	public String transferirValor() {
		try {
			new TransacaoDAO().inserir(this);
		} catch (SQLException e) {
			return null;
		}
		return "transacao_sucesso";
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
	
	
}
