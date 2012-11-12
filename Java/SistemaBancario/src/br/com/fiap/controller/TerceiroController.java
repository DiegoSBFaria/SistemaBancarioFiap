package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.TerceiraDao;
import br.com.fiap.model.Model;

@ManagedBean

public class TerceiroController implements Controller{
	private ArrayList<Model> contas;
	
	public ArrayList<Model> getContas() {
		//if(contas == null){
			TerceiraDao dao = new TerceiraDao();
			try {
				contas = dao.consultar(this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		return contas;
	}
}
