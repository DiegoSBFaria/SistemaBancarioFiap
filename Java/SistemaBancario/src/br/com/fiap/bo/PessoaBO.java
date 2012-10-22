package br.com.fiap.bo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PessoaBO implements BO {
	private Integer agencia;
	private Integer conta;
	private Integer digito;

	public String loginConta(){
		String msg = "erro";
		return msg;
	}
	
	public Integer getDigito() {
		return digito;
	}
	
	public void setDigito(Integer digito) {
		this.digito = digito;
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
