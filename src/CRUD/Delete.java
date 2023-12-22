package CRUD;

import java.sql.*;
import java.util.Scanner;

import Conexao.Conexao;
import LinkCurto.Encurtar;

public class Delete {

	public static void delete() throws SQLException {
		
		Scanner input = new Scanner(System.in);
		Connection conexao = Conexao.getConexao();
		
		System.out.print("Informe o codigo do site para ser deletado: ");
		int id = input.nextInt();
		
		String sql = "DELETE FROM ENCURTAR WHERE IDENCURTAR = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		if(stmt.executeUpdate() > 0) { 
			System.out.println("Site excluida com sucesso");
		} else {
			System.out.println("Não encontrado. Verifique o ID informado.");
		}

	}




}
