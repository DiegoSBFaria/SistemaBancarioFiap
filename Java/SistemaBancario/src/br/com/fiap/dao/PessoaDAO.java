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

	public boolean verificaSenha(Pessoa pessoa) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "CALL login(?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, pessoa.getId());
		stmt.setInt(2, pessoa.getSenha());
		
		ResultSet rs = stmt.executeQuery();
		boolean success = false;
		if(rs.first()){
			pessoa.setNome(rs.getString("nome"));
			pessoa.setSobrenome(rs.getString("sobrenome"));
			success = true;
		}
		conn.close();
		
		return success;		
	}
	
	public String getSaldo(int id) throws SQLException{
		String retorno = null;
Connection conn = ConnectionFactory.getConnection();
		
		String sql = "CALL saldo(?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.first()){
			retorno = String.valueOf(rs.getDouble("saldo"));
		}
		
		conn.close();
		return retorno;
	}
	
	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		return null;		
	}



}
