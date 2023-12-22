package Conexao;

import java.sql.*;

public class Conexao {

	final static String url = "SEU_CAMINHO_BANCO";
	final static String usuario = "ADMINISTRADOR";
	static String senha = "SENHA_BANCO";

	public static Connection getConexao() {
		
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	
	}

}
