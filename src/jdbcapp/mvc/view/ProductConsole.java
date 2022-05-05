package jdbcapp.mvc.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdbcapp.mvc.controller.ProductController;
import jdbcapp.mvc.entity.Product;
import jdbcapp.mvc.model.ProductDAO;
import jdbcapp.mvc.model.ProductDAOImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductConsole {
    ProductController productController = new ProductController();
    Product product = new Product();
    ProductDAO productDAO = new ProductDAOImpl();
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public ProductConsole() throws SQLException, ClassNotFoundException {
    }


    public int menu(){
        System.out.println("========Product Management========");
        System.out.println("Select your selection:");
        System.out.println("1. Create a product.");
        System.out.println("2. Find product by id.");
        System.out.println("3. Get all product.");
        System.out.println("4. Update a product.");
        System.out.println("5. Delete a product.");
        System.out.println("6. Get product by name.");
        System.out.println("7. Export product to Json file");
        System.out.println("8. Read Json file");
        System.out.println("9. Exit");
        int choice = readInt(0,9);
        return choice;
    }

    public int readInt(int min, int max){
        int choice;
        while (true){
            try{
                choice = Integer.parseInt(sc.next());
                if(choice >= min && choice <= max){
                    break;
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

        }
        return choice;
    }

    public void start() throws SQLException, ClassNotFoundException {
        while(true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);
                    break;
                case 1 : createStatement();
                    break;
                case 2 : productDAO.getProductById(product.getId());
                    break;
                case 3 : productDAO.getAllProduct();
                    break;
                case 4 : updateStatement();
                    break;
                case 5 : deleteStatement();
                    break;
                case 6 : productDAO.searchProductByName();
                    break;
                case 7 :
                    break;
                case 8 :
                    break;
                case 9 :
                    System.out.println("Thank you for using the services");
                    System.exit(0);
                default : throw new AssertionError();
            }
        }
    }

    public void createStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Enter your product's name: ");
        String prodName = sc2.nextLine();
        product.setProName(prodName);

        System.out.println("Enter your product's description: ");
        String prodDesc = sc1.nextLine();
        product.setProDesc(prodDesc);

        System.out.println("Enter your product's price: ");
        Double price = sc.nextDouble();
        product.setPrice(price);

        productController.createProductController(product);
    }
    public void updateStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Enter the product's id you want to update: ");
        Integer id = sc.nextInt();
        product.setId(id);

        System.out.println("Enter your new product information: ");
        System.out.println("Name: ");
        String name = sc2.nextLine();
        product.setProName(name);

        System.out.println("Description: ");
        String desc = sc1.nextLine();
        product.setProDesc(desc);

        System.out.println("Price: ");
        Double price = sc.nextDouble();
        product.setPrice(price);

        productController.updateProductController(product);
        System.out.println("Edit success!!!");
    }

    public void deleteStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Enter your product's id you want to delete: ");
        Integer deleteId = sc.nextInt();
        product.setId(deleteId);

        productController.deleteProductController(product.getId());
        System.out.println("Delete success!");
    }

    public void getDataWithJson() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        //read json file
        try{
            FileReader reader = new FileReader("Product.json");
            Object obj = parser.parse(reader);

            JSONArray productList = (JSONArray) obj ;

            productList.forEach(cus -> parseCustomerObject((JSONObject) cus));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

        private static void parseCustomerObject(JSONObject jsonObject){
            long id = (long) jsonObject.get("id");
            String proName = (String) jsonObject.get("proName");
            String proDesc = (String) jsonObject.get("proDesc");
            String price = (String) jsonObject.get("price");
            System.out.println(id + " - " + proName + " - " + proDesc + " - " + price);
        }

//    public void getDataWithGson(){
//        Gson gson = new Gson();
//        List<Product> productList;
//        try{
//            FileReader reader = new FileReader("Product.json");
//            productList = new Gson().fromJson(reader, new TypeToken<List<Product>>(){}.getType());
//
//            for (Product product: productList){
//                System.out.println(product);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//
//        }
//    }
}
