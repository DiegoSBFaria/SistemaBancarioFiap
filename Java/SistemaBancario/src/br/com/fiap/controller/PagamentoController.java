package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.util.Util;

@ManagedBean

public class PagamentoController implements Controller {
	private int senha;
	private Double valor;
	private String codigo;
	private String saldo;	
	private Integer data;
	
	public String efetuarPagamento(){
		String retorno = "erro";
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		
		if(Util.isSessionValid(request)){
			PessoaDAO dao = new PessoaDAO();
			try {
				if(Double.parseDouble(getSaldo()) >= valor){
					dao.efetuarPagamento(this);
					retorno = "home";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			retorno = "login";
		}
		return retorno;
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
	
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSaldo() {
		PessoaDAO dao = new PessoaDAO();
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		try {
			saldo = dao.getSaldo(Integer.parseInt(Util.getContaID(request)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
	
}
