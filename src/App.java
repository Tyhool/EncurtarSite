import Menu.Menu;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws Exception, SQLException{
        Menu menu = new Menu();
        menu.menu();
    }
}