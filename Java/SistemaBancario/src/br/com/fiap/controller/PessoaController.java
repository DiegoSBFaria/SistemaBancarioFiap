package br.com.fiap.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.model.Pessoa;

@ManagedBean

public class PessoaController implements Controller {
	private String agencia;
	private String conta;
	private String digito;
	private String senha;

	public String loginConta(){
		String msg = "erro";
		PessoaDAO dao = new PessoaDAO();
		try {
			Pessoa pessoa = (Pessoa) dao.existe(this);
			if(pessoa == null){
				//criar sessão
				msg = "loginSenha";
				FacesContext ctx = FacesContext.getCurrentInstance();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msg;
	}	
	public String loginSenha(){
		String msg = "erro";
		PessoaDAO dao = new PessoaDAO();
		try {
			Pessoa pessoa = (Pessoa) dao.existe(this);
			if(pessoa == null){
				//criar sessão
				
				msg = "loginSenha";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
}
