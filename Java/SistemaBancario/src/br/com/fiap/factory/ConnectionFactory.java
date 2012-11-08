package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static void registraDriverJdbc() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {

			ex.printStackTrace();

			System.exit(1);

		}
	}

	public static Connection getConnection() throws SQLException{
		
		String server = "174.120.239.188";
		String database = "merca392_banco_fiap";
		String usuario = "merca392_fiap";
		String senha = "fiap123";

		String url = "jdbc:mysql://" + server + "/" + database;

		registraDriverJdbc();
		return DriverManager.getConnection(url, usuario, senha);
		
	}
	
}
