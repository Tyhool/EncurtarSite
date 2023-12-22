package CRUD;
import java.sql.*;
import java.util.Scanner;

import Conexao.Conexao;
import LinkCurto.Encurtar;

public class Update {
//UPDATE

	public static void update() throws SQLException {

		Scanner input = new Scanner(System.in);
		Connection conexao = Conexao.getConexao();

		String select = "SELECT IDENCURTAR, SITE, LINKCURTO FROM ENCURTAR WHERE IDENCURTAR = ?";
		String update = "UPDATE ENCURTAR SET SITE = ? WHERE IDENCURTAR = ?";
		;

		System.out.println("Informe o ID para alteracao: ");
		Integer id = input.nextInt();

		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, id);

		ResultSet resultado = stmt.executeQuery();

		if (resultado.next()) {
            int idencurtar = resultado.getInt("idencurtar");
			String site = resultado.getString("site");
			String linkcurto = resultado.getString("linkcurto");

			Encurtar en = new Encurtar(idencurtar, site, linkcurto);

			System.out.println("O link atual é: " + en.getSite());
			input.nextLine();

			System.out.println("Informe o novo link: ");
			String novoLink = input.nextLine();

			
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoLink);
			stmt.setInt(2, id);

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Novo link alterado com sucesso");
			} else {
				System.out.println("ERRO: Verifique o ID informado.");
			}

		}
	}


}
