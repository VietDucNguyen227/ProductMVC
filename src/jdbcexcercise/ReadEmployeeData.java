package jdbcexcercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployeeData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Tra ve 1 doi tuong connection da ket noi den CSDL
        Connection connection = SQLServerConnection.getSQLServerConnection();
        //tao doi tuong statement
        Statement statement = connection.createStatement();

        //ket qua tra ve tu bang employee duoc luu tru
        ResultSet resultSet = statement.executeQuery("select * from employee");

        while (resultSet.next()) {
        {
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String name = resultSet.getString(3);
            System.out.println("--------------------");
            System.out.println("empID: " + empId);
            System.out.println("empNO: " + empNo);
            System.out.println("Name: " + name);
        }

    }
        connection.close();
    }
}


