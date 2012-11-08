package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.controller.Controller;
import br.com.fiap.controller.PessoaController;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Model;
import br.com.fiap.model.Pessoa;

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
		PessoaController pessoa = (PessoaController) controller;
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "CALL preLogin(?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, pessoa.getAgencia());
		stmt.setInt(2, pessoa.getConta());
		stmt.setInt(3, pessoa.getDigito());
		
		ResultSet rs = stmt.executeQuery();
		Pessoa p = null;
		if(rs.first()){
			p = new Pessoa();
			p.setId(rs.getInt("id"));
			p.setAgencia(pessoa.getAgencia());
			p.setConta(pessoa.getConta());
			p.setDigito(pessoa.getDigito());
		}
		conn.close();
		
		return p;		
	}

	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		return null;		
	}



}
