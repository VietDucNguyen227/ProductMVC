package jdbcexcercise;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatabase{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        Statement statement = connection.createStatement();
        String query = "insert into employee values(6, 'F006', 'Trong Tin')";

        int row = statement.executeUpdate(query);
        System.out.println("Row dc them vao: " + row);

    }
}
