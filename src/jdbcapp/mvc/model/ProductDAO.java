package jdbcapp.mvc.model;

import jdbcapp.mvc.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    //Create product
    public String createProduct(Product product) throws SQLException, ClassNotFoundException;

    //Read product by id
    public Product getProductById(int id) throws SQLException, ClassNotFoundException;

    //Get all products
    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException;

    //update products
    public void updateProduct(Product product) throws SQLException, ClassNotFoundException;

    //delete products
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;

    //get product by name
    public void searchProductByName() throws SQLException, ClassNotFoundException;

}
