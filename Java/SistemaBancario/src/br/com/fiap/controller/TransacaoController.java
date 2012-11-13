package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> cookies = externalContext.getSessionMap();
		PessoaController p = (PessoaController)cookies.get("pessoaController");
		pessoa = p.getPessoa();
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
	


	public void validateSenha(FacesContext context, UIComponent componentToValidate, Object value){

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> cookies = externalContext.getSessionMap();
		PessoaController pessoa = (PessoaController)cookies.get("pessoaController");
		if(senha != pessoa.getSenha()){
			FacesMessage message = new FacesMessage("Senhas incompat’veis.");
			throw new ValidatorException(message);
		}
	}
	
	
}
