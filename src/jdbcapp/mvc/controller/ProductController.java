package jdbcapp.mvc.controller;

import jdbcapp.mvc.entity.Product;
import jdbcapp.mvc.model.ProductDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductDAOImpl productDAO = new ProductDAOImpl();

    public ProductController() throws SQLException, ClassNotFoundException {
    }

    public String createProductController(Product product) throws SQLException, ClassNotFoundException {
        return productDAO.createProduct(product);
    }

    public Product getProductByIdController(int id) throws SQLException, ClassNotFoundException {
        return productDAO.getProductById(id);
    }

    public ArrayList<Product> getAllProductController() throws SQLException, ClassNotFoundException {
        return productDAO.getAllProduct();
    }

    public void updateProductController(Product product) throws SQLException, ClassNotFoundException {
        productDAO.updateProduct(product);
    }

    public boolean deleteProductController(int id) throws SQLException, ClassNotFoundException {
        return productDAO.deleteProduct(id);
    }

    public void searchProductByNameController() throws SQLException, ClassNotFoundException {
        productDAO.searchProductByName();
    }

}
