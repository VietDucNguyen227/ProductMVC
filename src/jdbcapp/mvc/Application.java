package jdbcapp.mvc;

import jdbcapp.mvc.view.LoginConsole;
import jdbcapp.mvc.view.ProductConsole;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        ProductConsole productConsole = new ProductConsole();
//        productConsole.start();

        productConsole.getDataWithJson();
        productConsole.getDataWithGson();
    }
}
