package br.com.fiap.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.controller.Controller;
import br.com.fiap.controller.TransacaoController;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Model;
import br.com.fiap.util.Util;

public class TransacaoDAO implements DAO {

	@Override
	public void deletar(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Controller controler) throws SQLException {
		TransacaoController transacaoControler = (TransacaoController) controler;
		String sql = "transferencia(?, ?, ?, ?, ?)";
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		
		PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
		ps.setInt(1, transacaoControler.getAgencia());
		ps.setInt(2, transacaoControler.getConta());
		ps.setInt(3, transacaoControler.getDigito());
		ps.setDouble(4, transacaoControler.getValor());
		
		ps.setInt(5, Integer.parseInt(Util.getContaID(request)));
		ps.execute();
	}

	@Override
	public void atualizar(Controller controler) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Model existe(Controller controller) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
