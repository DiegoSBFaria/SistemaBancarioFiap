package br.com.fiap.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.model.Pessoa;
import br.com.fiap.util.Util;

@SessionScoped
@ManagedBean

public class PessoaController implements Controller {
	private Integer agencia;
	private Integer conta;
	private Integer digito;
	private Integer senha;
	private Pessoa pessoa;

	public String loginConta() {
		String msg = "erro";
		PessoaDAO dao = new PessoaDAO();
		try {
			pessoa = new Pessoa();
			pessoa = (Pessoa) dao.existe(this);
			if (pessoa != null) {
				// criar sessão
				msg = "loginSenha";
				ExternalContext context = FacesContext.getCurrentInstance()
						.getExternalContext();
				HttpServletResponse response = (HttpServletResponse) context.getResponse();
				Cookie cookie = new Cookie("entrou", "1");
				cookie.setMaxAge(100);
				response.addCookie(cookie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return msg;
	}

	public String loginSenha() {
		String msg = "erro";
		pessoa.setSenha(senha);
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		
		if(Util.isSessionValid(request)){
			PessoaDAO dao = new PessoaDAO();
			try {
				boolean success = dao.verificaSenha(pessoa);
				if(success){
					msg = "home";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			msg = "login";
		}

		return msg;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
