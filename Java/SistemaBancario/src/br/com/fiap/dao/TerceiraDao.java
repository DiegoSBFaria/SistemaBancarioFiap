package br.com.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.controller.Controller;
import br.com.fiap.model.ContaTerceiro;
import br.com.fiap.model.Model;

public class TerceiraDao implements DAO {

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
