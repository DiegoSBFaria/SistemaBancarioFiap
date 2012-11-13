package br.com.fiap.model;

import java.sql.SQLException;

import br.com.fiap.dao.PessoaDAO;

public class Pessoa implements Model {
	private int id;
	private int conta;
	private int digito;
	private int agencia;
	private int senha;
	private String nome;

	private String sobrenome;
	private String saldo;
	private String tipoConta;

	public int getId() {
		return id;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSaldo() {
		PessoaDAO dao = new PessoaDAO();
		try {
			saldo = "Seu saldo Ž de " + dao.getSaldo(getId()) + " reais";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			saldo = "Sem saldo.";
		}
		return saldo;
	}

}
