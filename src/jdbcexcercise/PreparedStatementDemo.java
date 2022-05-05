package jdbcexcercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query = "select * from employee where empId = ? and name like ?";
        //tao PreparedStatement
        //tham so truyen vao cho PreparedStatement phai duoi dang "?"

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //set gia tri cho tham so cua PreparedStatement
        preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "DatDaiji");

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println("------------------");
            System.out.println("empID: " +resultSet.getInt(1));
            System.out.println("empNo: " +resultSet.getString(2));
            System.out.println("Name: " +resultSet.getString(3));
        }

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"HoangLong");
        resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println("------------------");
            System.out.println("empID: " +resultSet.getInt(1));
            System.out.println("empNo: " +resultSet.getString(2));
            System.out.println("Name: " +resultSet.getString(3));
        }
    }
}
