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
import br.com.fiap.controller.PagamentoController;
import br.com.fiap.controller.PessoaController;
import br.com.fiap.controller.TransacaoController;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Comprovante;
import br.com.fiap.model.Model;
import br.com.fiap.model.Pessoa;
import br.com.fiap.util.Util;

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
		if (rs.first()) {
			p = new Pessoa();
			p.setId(rs.getInt("id"));
			p.setAgencia(pessoa.getAgencia());
			p.setConta(pessoa.getConta());
			p.setDigito(pessoa.getDigito());
			p.setTipoConta(rs.getString("tipo_conta"));
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
		if (rs.first()) {
			pessoa.setNome(rs.getString("nome"));
			pessoa.setSobrenome(rs.getString("sobrenome"));
			success = true;
		}
		conn.close();

		return success;
	}

	public String getSaldo(int id) throws SQLException {
		String retorno = null;
		Connection conn = ConnectionFactory.getConnection();

		String sql = "CALL saldo(?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		if (rs.first()) {
			retorno = String.valueOf(rs.getDouble("saldo"));
		}

		conn.close();
		return retorno;
	}

	public void efetuarPagamento(PagamentoController controller)
			throws SQLException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		Connection conn = ConnectionFactory.getConnection();

		String sql = "CALL pagamento(?,?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, Integer.parseInt(Util.getContaID(request)));
		stmt.setDouble(2, controller.getValor());
		stmt.setString(3, controller.getCodigo());
		stmt.setString(4, String.valueOf(controller.getData()));

		stmt.executeQuery();
		
		conn.close();
	}

	public void efetuarTransacao(TransacaoController controller)
			throws SQLException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		Connection conn = ConnectionFactory.getConnection();
		//transferencia(IN _id_conta INT, IN _agencia_destino INT, _numero_conta_destino INT, _digito_conta_destino INT, _valor INT)
		String sql = "CALL transferencia(?,?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, Integer.parseInt(Util.getContaID(request)));
//		stmt.setDouble(2, controller.getValor());
//		stmt.setString(3, controller.getCodigo());
//		stmt.setString(4, String.valueOf(controller.getData()));

		stmt.executeQuery();
		
		conn.close();
	}

	@Override
	public ArrayList<Model> consultar(Controller controler) throws SQLException {
		return null;
	}
	public ArrayList<Comprovante> getComprovante() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<Comprovante> comprovante = new ArrayList<Comprovante>();
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		String sql = "CALL comprovanteTransacao(?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, Integer.parseInt(Util.getContaID(request)));

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Comprovante p = new Comprovante();
			p.setValor(rs.getString("valor"));
			p.setData(rs.getInt("data"));
			p.setCodigoBarra(rs.getString("codigo_barras"));
			p.setNome(rs.getString("nome_terceiro"));
			p.setNumero(rs.getString("conta_terceiro"));
		}
		conn.close();
		return comprovante;
	}

}
