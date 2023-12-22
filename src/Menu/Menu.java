package Menu;

import java.sql.*;
import java.util.Scanner;

import Acesso.Acessar;
import Conexao.Conexao;
import CRUD.*;

public class Menu {
    String lixo = "";
    String entrada;
    boolean sair = true;
    boolean subsair = true;
    Scanner input = new Scanner(System.in);
    Connection conexao = Conexao.getConexao();

    public void menu() throws SQLException {

        int opcao = 0;
        int subopcao = 0;

        Create create = new Create();
        Read read = new Read();
        Update update = new Update();
        Delete delete = new Delete();
        Acessar acessar = new Acessar();

        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("-----|             MENU PRINCIPAL                   |-----");
            System.out.println("-----|                                              |-----");
            System.out.println("-----|           Escolha uma opcao:                 |-----");
            System.out.println("-----|                                              |-----");
            System.out.println("-----|  1 - Novo link                               |-----");
            System.out.println("-----|  2 - Listar link                             |-----");
            System.out.println("-----|  3 - Alterar link                            |-----");
            System.out.println("-----|  4 - Deletar link                            |-----");
            System.out.println("-----|  5 - Acessar o link                          |-----");
            System.out.println("-----|  9 - Sair:                                   |-----");
            System.out.println("----------------------------------------------------------");
            System.out.print("Opção: ");
            entrada = input.next();
            opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        create.create();
                        continue;
                    case 2:
                        read.read();
                        continue;
                    case 3:
                        update.update();
                        continue;
                    case 4:
                        delete.delete();
                        continue;
                    case 5:
                        acessar.acessar();
                        continue;
                    case 9:
                    sair = false;

                }

        } while (sair);
        input.close();
        
    }
}
