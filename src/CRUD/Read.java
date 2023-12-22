package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import LinkCurto.Encurtar;
import Conexao.Conexao;


public class Read {

	public static void read() throws SQLException {
		
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT * FROM ENCURTAR";

		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		List<Encurtar> encurtars = new ArrayList<>();

		while(resultado.next()){
			int idencurtar = resultado.getInt("idencurtar");
			String site = resultado.getString("site");
			String linkcurto = resultado.getString("linkcurto");
			encurtars.add(new Encurtar(idencurtar, site, linkcurto));
		}

        System.out.println("id || Link Curto                || Site caminho");
        System.out.println("-----------------------------------------------");
		for(Encurtar en : encurtars){
			System.out.println(en.getIdencurtar() + " => "  +  en.getLinkcurto() + " => " + en.getSite());
		}

	

	}

}

