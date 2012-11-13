package br.com.fiap.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.util.Util;

@ManagedBean
public class HomeController implements Controller {

	public String terceiro() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "contaTerceiro";
		}
		return retorno;
	}

	public String saldo() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "saldo";
		}
		return retorno;
	}

	public String extrato() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "extrato";
		}
		return retorno;
	}

	public String pagamento() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "pagamentoConta";
		}
		return retorno;
	}

	public String transferencia() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "transferir";
		}
		return retorno;
	}

	public String comprovante() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "comprovante";
		}
		return retorno;
	}

	public String agendamento() {
		String retorno = "login";

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			retorno = "agendamento";
		}
		return retorno;
	}

	public String logout() {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpServletResponse response = (HttpServletResponse) context
				.getResponse();
		Util.deleteCookie(request, response);
		return "login";
	}
}
