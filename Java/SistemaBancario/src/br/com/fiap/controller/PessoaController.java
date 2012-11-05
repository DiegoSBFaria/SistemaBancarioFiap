package br.com.fiap.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.model.Pessoa;

@ManagedBean
public class PessoaController implements Controller {
	private Integer agencia;
	private Integer conta;
	private Integer digito;
	private String senha;

	public String loginConta() {
		String msg = "erro";
		PessoaDAO dao = new PessoaDAO();
		try {
			Pessoa pessoa = (Pessoa) dao.existe(this);
			if (pessoa == null) {
				// criar sessão
				msg = "loginSenha";
				ExternalContext context = FacesContext.getCurrentInstance()
						.getExternalContext();
				HttpServletRequest request = (HttpServletRequest) context.getRequest();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return msg;
	}

	public String loginSenha() {
		String msg = "erro";
		msg = "home";
//		PessoaDAO dao = new PessoaDAO();
//		try {
//			Pessoa pessoa = (Pessoa) dao.existe(this);
//			if (pessoa == null) {
//				// criar sessão
//
//				msg = "home";
//			}else{
//				msg = "home";
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		return msg;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
}
