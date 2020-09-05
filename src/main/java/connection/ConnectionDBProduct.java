package connection;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ConnectionDBProduct {
    public void insertProduct(Product product) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;

    public boolean deleteProduct(int id) throws SQLException;

    public List<Product> selectProductByName(String name);

    public Product selectProductByCode(int id);

    public Product selectProductById(int id);

    public List<Product> selectAllProduct();

    public List<Product> selectProductOfShirt();

    public List<Product> selectProductOfTrousers();

    public List<Product> selectProductOfShoes();
}
