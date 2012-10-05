package br.com.fiap.bo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PessoaBO implements BO {
	private String agencia;
	private String conta;
	private String digito;

	public String loginConta(){
		String msg = "erro";
		return msg;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public void setDigito(String digito) {
		this.digito = digito;
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
