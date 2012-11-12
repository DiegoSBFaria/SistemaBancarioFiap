package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.controller.Controller;
import br.com.fiap.controller.ExtratoController;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Extrato;
import br.com.fiap.model.Model;
import br.com.fiap.util.Util;

public class ExtratoDAO implements DAO {

	@Override
	public void deletar(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserir(Controller controler) throws SQLException {
		// TODO Auto-generated method stub

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
		ExtratoController extrato = (ExtratoController) controler;
		Connection conn = ConnectionFactory.getConnection();

		String sql = "CALL extrato(?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		stmt.setInt(1, Integer.parseInt(Util.getContaID(request)));
		if (extrato.getPeriodo() == 0) {
			stmt.setInt(2, extrato.getDataInicio());
			stmt.setInt(3, extrato.getDataFim());
		} else {
			stmt.setInt(2, extrato.getPeriodo());
			stmt.setInt(3, extrato.getPeriodo());
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<Model> extratos = new ArrayList<Model>();
		while(rs.next()){
			Extrato e = new Extrato();
			e.setValor(rs.getString(1));
			e.setData(rs.getInt(2));
			e.setCodigoBarra(rs.getString(3));
			e.setNome(rs.getString(4));
			e.setConta(rs.getString(5));
			extratos.add(e);
		}
		return extratos;
	}

}
