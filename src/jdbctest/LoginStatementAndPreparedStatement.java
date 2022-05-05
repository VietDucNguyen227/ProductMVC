package jdbctest;
//1. load and register driver
//2. create connection
//3. statement
//4. result set
//5. close connection
import jdbcexcercise.SQLServerConnection;

import java.sql.*;

public class LoginStatementAndPreparedStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        loginStatement("'' or 1=1--'", "'admin'");
        loginPreparedStatement("admin", "admin");

    }
    public static void loginStatement(String username, String password) throws SQLException, ClassNotFoundException {
        //step1+2
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "select username from users where username =" +username+" " +"and password="+password+"";
        //step3
        Statement statement = connection.createStatement();
        //step4
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println("login thang cong: "+resultSet.getString("username"));
        }


    }
    public static void loginPreparedStatement(String username, String password) throws SQLException, ClassNotFoundException {
         Connection connection = SQLServerConnection.getSQLServerConnection();
         String query = "select username from users where username =? and password =?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1,username);
         preparedStatement.setString(2,password);

         ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()){
             System.out.println("Login success: " +resultSet.getString("username"));
         }
    }
}
