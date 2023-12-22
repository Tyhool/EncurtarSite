package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import GerarRandom.GerarPalavraAleatoria;
import Conexao.Conexao;

public class Create {
    public void create() throws SQLException {
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int tamanhoPalavra = 10;
        GerarPalavraAleatoria gPAleatoria = new GerarPalavraAleatoria();
        String siteInicial = "enderecoCurta.com/";
        Connection conexao = Conexao.getConexao(); 

		Scanner input = new Scanner(System.in);

		System.out.print("Informe o site: ");
		String site = input.nextLine();

        String sql = "INSERT INTO encurtar(SITE, LINKCURTO) VALUES (?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        String gpa = gPAleatoria.gerarPalavraAleatoria(alfabeto, tamanhoPalavra);

        stmt.setString(1, site);
		stmt.setString(2, siteInicial + gpa);
		
		stmt.execute();
				
		System.out.println("Site inserido com sucesso");


        System.out.println("Site curto: "+ (siteInicial + gpa));
    }
}
