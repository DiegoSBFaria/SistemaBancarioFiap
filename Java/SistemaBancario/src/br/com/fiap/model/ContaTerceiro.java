package br.com.fiap.model;

public class ContaTerceiro implements Model{
	private String nome;
	private int id;
	private int conta;
	private int agencia;
	private int digito;
	private int id_conta;
	private Integer id_conta_ref;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
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

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public Integer getId_conta_ref() {
		return id_conta_ref;
	}

	public void setId_conta_ref(Integer id_conta_ref) {
		this.id_conta_ref = id_conta_ref;
	}
	
}
