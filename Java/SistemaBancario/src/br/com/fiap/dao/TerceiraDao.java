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
		stmt.setString(2, String.valueOf(terceiro.getAgencia()));
		stmt.setString(3, String.valueOf(terceiro.getConta()));
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
		// TODO Auto-generated method stub

	}

	@Override
	public Model existe(Controller controller) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		ArrayList<Model> contas = new ArrayList<Model>();
		for(int i = 0; i < 5; i++){
			ContaTerceiro conta = new ContaTerceiro();
			conta.setId(i);
			conta.setNome("Teste");
			conta.setAgencia(1234);
			conta.setDigito(5);
			conta.setConta(12345);
			contas.add(conta);
		}
		return contas;
	}

}
