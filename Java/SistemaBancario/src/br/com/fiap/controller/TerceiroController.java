package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.TerceiraDao;
import br.com.fiap.model.Model;

@ManagedBean
public class TerceiroController implements Controller {

	private String nome;
	private Integer conta;
	private Integer agencia;
	private Integer digito;

	private ArrayList<Model> contas;

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
