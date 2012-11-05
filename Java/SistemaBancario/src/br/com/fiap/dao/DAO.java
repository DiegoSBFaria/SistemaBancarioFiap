package br.com.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.controller.Controller;
import br.com.fiap.model.Model;

public interface DAO {
	public abstract void deletar(int id) throws SQLException;
	public abstract void inserir(Controller controler)throws SQLException;
	public abstract void atualizar(Controller controler)throws SQLException;
	public abstract Model existe(Controller controller)throws SQLException;
	public abstract ArrayList<Model> consultar(Controller controler)throws SQLException;
}
