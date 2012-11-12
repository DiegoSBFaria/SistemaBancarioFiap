package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.dao.ExtratoDAO;
import br.com.fiap.model.Model;
import br.com.fiap.util.Util;

@ManagedBean
public class ExtratoController implements Controller {

	private Integer periodo;
	private Integer dataInicio;
	private Integer dataFim;
	private ArrayList<Model> extratos = new ArrayList<Model>();

	public String filtrar() {
		String retorno = "erro";
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (Util.isSessionValid(request)) {
			ExtratoDAO dao = new ExtratoDAO();
			try {
				setExtratos(new ArrayList<Model>());
				setExtratos(dao.consultar(this));
				retorno = "verExtrato";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			retorno = "login";
		}
		return retorno;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Integer getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Integer dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getDataFim() {
		return dataFim;
	}

	public void setDataFim(Integer dataFim) {
		this.dataFim = dataFim;
	}

	public ArrayList<Model> getExtratos() {
		return extratos;
	}

	public void setExtratos(ArrayList<Model> extratos) {
		this.extratos = extratos;
	}
}
