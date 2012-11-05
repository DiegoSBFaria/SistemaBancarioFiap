package br.com.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.controller.Controller;
import br.com.fiap.model.Model;

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
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		return null;		
	}



}
