package Acesso;

import java.sql.*;
import java.util.Scanner;

import Conexao.Conexao;

public class Acessar {

    public static void acessar() throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do site que deseja acessar:");
        int idSite = scanner.nextInt();

        String linkCurto = acessarLink(idSite);

        if (linkCurto != null) {
            System.out.println("Acessando o site: " + linkCurto + " no terminal.");
            abrirNavegador(linkCurto);
        } else {
            System.out.println("Site não encontrado.");
        }

        
    }

    private static String acessarLink(int idSite) {
        String linkCurto = null;

        try (Connection connection = Conexao.getConexao()) {
            String sql = "SELECT linkcurto, site FROM encurtar WHERE idencurtar = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idSite);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        linkCurto = resultSet.getString("linkcurto");
                        String link = resultSet.getString("site");
                        abrirNavegador(link);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linkCurto;
    }

    private static void abrirNavegador(String link) {
        // Lógica para abrir o navegador com o link
        // Implemente essa parte de acordo com o seu sistema operacional e navegador preferido
        // Exemplo para Windows usando o navegador padrão:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + link);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
