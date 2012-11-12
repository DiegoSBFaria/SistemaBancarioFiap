package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.dao.TerceiraDao;
import br.com.fiap.model.ContaTerceiro;
import br.com.fiap.util.Util;

@ApplicationScoped
@ManagedBean

public class TerceiroUController implements Controller {
	private ContaTerceiro conta;
	private String projectId;

	public String atualizar() {
		String retorno = "erro";
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();

		if (Util.isSessionValid(request)) {
			TerceiraDao dao = new TerceiraDao();
			try {
				dao.atualizar(this);
				retorno = "contaTerceiro";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			retorno = "login";
		}
		return retorno;
	}

	public String excluir() {
		return null;
	}

	public ContaTerceiro getConta() {
		if (conta == null) {
			conta = new ContaTerceiro();
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, String> paramMap = context.getExternalContext()
					.getRequestParameterMap();
			setProjectId(paramMap.get("id"));
			TerceiraDao dao = new TerceiraDao();
			try {
				conta = (ContaTerceiro) dao.existe(this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conta;
	}

	public void setConta(ContaTerceiro conta) {
		this.conta = conta;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
