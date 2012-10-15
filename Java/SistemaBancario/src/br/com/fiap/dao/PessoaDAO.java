package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.controller.Controller;
import br.com.fiap.model.Model;
import br.com.fiap.factory.*;

public class PessoaDAO implements DAO {

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
		
//		Connection conn = ConnectionFactory.getConnection();
//		
//		String sql = "SELECT * FROM profissional ORDER BY nome";
//		
//		PreparedStatement stmt = conn.prepareStatement(sql);
//			
//
//		conn.close();
		
		return null;		
	}

	@Override
	public void consultar(Controller controler) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
