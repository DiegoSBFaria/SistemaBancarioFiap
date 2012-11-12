package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.dao.TerceiraDao;
import br.com.fiap.model.Model;
import br.com.fiap.util.Util;

@ManagedBean
public class TerceiroController implements Controller {

	private String nome;
	private Integer conta;
	private Integer agencia;
	private Integer digito;

	private ArrayList<Model> contas;

	public String cadastrar(){
		String retorno = "erro";
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		
		if(Util.isSessionValid(request)){
			TerceiraDao dao = new TerceiraDao();
			try {
				dao.inserir(this);
				retorno = "contaTerceiro";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			retorno = "login";
		}
		return retorno;
	}
	
	public ArrayList<Model> getContas() {
		TerceiraDao dao = new TerceiraDao();
		try {
			contas = dao.consultar(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}
}
