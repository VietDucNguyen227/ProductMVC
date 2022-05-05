package jdbcexcercise;

import java.sql.*;

public class CallabeStatementDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query = "{call getEmployeeInfo(?,?,?)}";

        CallableStatement callableStatement = connection.prepareCall(query);

        //Truyen tham so
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        callableStatement.executeUpdate();
        int empId = callableStatement.getInt(1);
        String empNo = callableStatement.getString(2);
        String name = callableStatement.getString(3);

        System.out.println("Emp id: " +empId);
        System.out.println("Emp no: " +empNo);
        System.out.println("name: " +name);
    }

}
