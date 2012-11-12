package br.com.fiap.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.fiap.model.Comprovante;

@ManagedBean

public class ComprovanteController implements Controller {
	private ArrayList<Comprovante> comprovantes;

	public ArrayList<Comprovante> getComprovantes() {
		comprovantes = new ArrayList<Comprovante>();
		return comprovantes;
	}
}
