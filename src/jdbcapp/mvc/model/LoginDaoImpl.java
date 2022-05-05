package jdbcapp.mvc.model;

import jdbcexcercise.SQLServerConnection;
import jdbcapp.mvc.entity.Users;

import java.sql.*;

public class LoginDaoImpl implements LoginDAO{
    @Override
    public String checkLoginStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query = "select username from users where username = '" +users.getUsername()+"'"
                +"and password= '"+users.getPassword()+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            System.out.println("Login Thanh Cong : " + resultSet.getString("username"));
            return users.getUsername();
        }
        return "failed!";
    }

    @Override
    public String checkLoginPreparedStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "select username from users where username =? and password =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, users.getUsername());
        preparedStatement.setString(2, users.getPassword());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Login Thanh Cong: " + resultSet.getString("username"));
            return users.getUsername();
        }
        return "Login Failed";
    }
}
