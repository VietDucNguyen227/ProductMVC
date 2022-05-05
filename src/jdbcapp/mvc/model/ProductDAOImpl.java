package jdbcapp.mvc.model;
import jdbcapp.mvc.dao.SQLServerConnection;
import jdbcapp.mvc.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDAOImpl implements ProductDAO{
    private final Connection connection = SQLServerConnection.getSQLServerConnection();

    public ProductDAOImpl() throws SQLException, ClassNotFoundException {
    }

    private final String SQL_CREATE_PRODUCT = "insert into product values(?,?,?)";
    private final String SQL_GET_PRODUCT_BY_ID = "select * from product where id=?";
    private final String SQL_UPDATE_PRODUCT = "update product set proName = ?, proDesc = ?, price = ? where id=?";
    private final String SQL_DELETE_PRODUCT = "delete from product where id=?";
    private final String SQL_FIND_PRODUCT_BY_NAME = "select * from product where proName=?";
    private final String SQL_GET_ALL_PRODUCT = "select * from product";

    @Override
    public String createProduct(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_PRODUCT, Statement.RETURN_GENERATED_KEYS);//tao ra id tu dong
        preparedStatement.setString(1, product.getProName());
        preparedStatement.setString(2, product.getProDesc());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            product.setId(resultSet.getInt(1));
        }
        return null;
    }

    @Override
    public Product getProductById(int id) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id you want to search: ");
        Integer inputID = sc.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PRODUCT_BY_ID);
        preparedStatement.setInt(1, inputID);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()==false)
        {
            System.out.println("Name not found in the database");
        }
        else
        {
            System.out.println("Here is the information of the employee: ");
            System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getDouble(4) );

        }
        return null;
    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_PRODUCT);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            {
                Integer id = resultSet.getInt(1);
                String proName = resultSet.getString(2);
                String proDes = resultSet.getString(3);
                Double price = resultSet.getDouble(4);
                System.out.println("--------------------");
                System.out.println("Product's ID: " + id);
                System.out.println("Product's Name: " + proName);
                System.out.println("Product's Description: " + proDes);
                System.out.println("Product's Price: " + price);
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCT);
        preparedStatement.setString(1, product.getProName());
        preparedStatement.setString(2, product.getProDesc());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
            return true;
    }

    @Override
    public void searchProductByName() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Your Product's name");
        Scanner input = new Scanner(System.in);
        String inputname = input.nextLine();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_NAME);
        preparedStatement.setString(1, inputname);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()==false)
        {
            System.out.println("Name not found in the database");
        }
        else
        {
            System.out.println("Here is the information of the product: ");
            System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getDouble(4) );
        }
        connection.close();
    }
}
