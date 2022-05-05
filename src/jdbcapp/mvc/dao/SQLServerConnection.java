package jdbcapp.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String instanceName = "LAPTOP-SDGHQO5D";
        String databaseName = "myjdbcapp";
        String userName = "sa";
        String password = "shiroukrs1";
        return getSQLServerConnection(hostName, instanceName, databaseName, userName, password);
    }
    public static Connection getSQLServerConnection(String hostname,
                                                    String instanceName,
                                                    String databaseName,
                                                    String userName,
                                                    String password)
            throws SQLException, ClassNotFoundException{



        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionString = "jdbc:sqlserver://" +hostname+ ":1433" +";instance="+ instanceName+ ";databaseName= "+databaseName;

        Connection connection = DriverManager.getConnection(connectionString,userName,password);
        return connection ;
    }
}
