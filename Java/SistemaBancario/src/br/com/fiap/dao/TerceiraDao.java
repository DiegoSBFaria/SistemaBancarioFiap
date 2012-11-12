package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fiap.controller.Controller;
import br.com.fiap.controller.TerceiroController;
import br.com.fiap.controller.TerceiroUController;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.ContaTerceiro;
import br.com.fiap.model.Model;
import br.com.fiap.util.Util;

public class TerceiraDao implements DAO {

	@Override
	public void deletar(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserir(Controller controler) throws SQLException {
		TerceiroController terceiro = (TerceiroController) controler;
		Connection conn = ConnectionFactory.getConnection();

		String id = null;
		String sql = "SELECT id FROM contas WHERE agencia = ? AND numero = ? AND digito = ? AND tipo_conta = 'c'";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, String.valueOf(terceiro.getAgencia()));
		stmt.setString(2, String.valueOf(terceiro.getConta()));
		stmt.setString(3, String.valueOf(terceiro.getDigito()));

		ResultSet rs = stmt.executeQuery();
		if(rs.first()){
			id = String.valueOf(rs.getInt(1));
		}
		sql = "CALL inserirTerceiro(?,?,?,?,?,?)";

		stmt = conn.prepareStatement(sql);
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		stmt.setString(1, terceiro.getNome());
		stmt.setString(2, String.valueOf(terceiro.getConta()));
		stmt.setString(3, String.valueOf(terceiro.getAgencia()));
		stmt.setString(4, String.valueOf(terceiro.getDigito()));
		stmt.setInt(5, Integer.parseInt(Util.getContaID(request)));
		if(id != null)
			stmt.setInt(6, Integer.parseInt(id));
		else
			stmt.setNull(6, Types.INTEGER);
		
		stmt.executeQuery();
	}

	@Override
	public void atualizar(Controller controler) throws SQLException {
		TerceiroUController terceiro = (TerceiroUController) controler;

		Connection conn = ConnectionFactory.getConnection();

		String sql = "CALL atualizarTerceiro(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, terceiro.getConta().getId());
		stmt.setString(2, terceiro.getConta().getNome());
		stmt.setString(3, String.valueOf(terceiro.getConta().getConta()));
		stmt.setString(4, String.valueOf(terceiro.getConta().getAgencia()));
		stmt.setString(5, String.valueOf(terceiro.getConta().getAgencia()));
		stmt.setInt(6, terceiro.getConta().getId_conta());
		if(terceiro.getConta().getId_conta_ref() != null)
			stmt.setInt(7, terceiro.getConta().getId_conta_ref());
		else
			stmt.setNull(7, Types.INTEGER);
		
		stmt.executeQuery();
	}

	@Override
	public Model existe(Controller controller) throws SQLException {
		TerceiroUController terceiro = (TerceiroUController) controller;
		ContaTerceiro conta = null;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM terceiros WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, Integer.parseInt(terceiro.getProjectId()));

		ResultSet rs = stmt.executeQuery();
		if(rs.first()){
			conta = new ContaTerceiro();
			conta.setId(rs.getInt("id"));
			conta.setNome(rs.getString("nome"));
			conta.setAgencia(Integer.parseInt(rs.getString("agencia")));
			conta.setDigito(Integer.parseInt(rs.getString("digito")));
			conta.setConta(Integer.parseInt(rs.getString("numero_conta")));
			conta.setId_conta(Integer.parseInt(rs.getString("conta_id")));
			rs.getString("conta_referenciada_id");
			if(!rs.wasNull()){
				conta.setId_conta_ref(Integer.parseInt(rs.getString("conta_referenciada_id")));
			}
		}
		return conta;
	}

	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		ArrayList<Model> contas = new ArrayList<Model>();
		Connection conn = ConnectionFactory.getConnection();

		String sql = "CALL listarTerceiros(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();

		stmt.setInt(1, Integer.parseInt(Util.getContaID(request)));
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			ContaTerceiro conta = new ContaTerceiro();
			conta.setId(rs.getInt("id"));
			conta.setNome(rs.getString("nome"));
			conta.setAgencia(Integer.parseInt(rs.getString("agencia")));
			conta.setDigito(Integer.parseInt(rs.getString("digito")));
			conta.setConta(Integer.parseInt(rs.getString("numero_conta")));
			conta.setId_conta(Integer.parseInt(rs.getString("conta_id")));
			rs.getString("conta_referenciada_id");
			if(!rs.wasNull()){
				conta.setId_conta_ref(Integer.parseInt(rs.getString("conta_referenciada_id")));
			}
			contas.add(conta);
		}
		
		return contas;
	}

}
