package br.com.fiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.model.Comprovante;

@ManagedBean

public class ComprovanteController implements Controller {
	private ArrayList<Comprovante> comprovantes;

	public ArrayList<Comprovante> getComprovantes() {
		comprovantes = new ArrayList<Comprovante>();
		PessoaDAO dao = new PessoaDAO();
		try {
			comprovantes = dao.getComprovante();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comprovantes;
	}
}
