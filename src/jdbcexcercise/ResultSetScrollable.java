package jdbcexcercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScrollable {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        //tao statement it nhay cam voi su thay doi, read only
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        String query = "select * from employee";
        //Thuc thi chi thi cua SQL thong qua statement
        ResultSet resultSet = statement.executeQuery(query);
        //di chuyen toi cuoi ban ghi
        boolean last = resultSet.last();
        System.out.println("last: " +last);
        if(last){
            //ghi ra ban ghi cua last
            System.out.println("employee's id: " +resultSet.getInt(1));
            System.out.println("employee's no: " +resultSet.getString(2));
            System.out.println("employee's name: " +resultSet.getString(3));
        }
        //di chuyen toi dau ban ghi
        boolean first = resultSet.first();
        System.out.println("first: " +first);
        if(first){
            //ghi ra ban ghi cua last
            System.out.println("employee's id: " +resultSet.getInt(1));
            System.out.println("employee's no: " +resultSet.getString(2));
            System.out.println("employee's name: " +resultSet.getString(3));
        }

        while(resultSet.next())
        {
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String name = resultSet.getString(3);
            System.out.println("--------------------");
            System.out.println("empID: " + empId);
            System.out.println("empNO: " + empNo);
            System.out.println("Name: " + name);
        }
        connection.close();
    }
}
