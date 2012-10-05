package br.com.fiap.dao;

import br.com.fiap.bo.BO;

public interface DAO {
	public abstract void deletar(int id);
	public abstract void inserir(BO bo);
	public abstract void atualizar(BO bo);
	public abstract void existe(int id);
	public abstract void consultar(BO bo);
}
