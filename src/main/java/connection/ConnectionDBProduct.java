package connection;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ConnectionDBProduct {
    public void insertProduct(Product product) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;

    public boolean deleteProduct(int id) throws SQLException;

    public List<Product> selectAllProduct();

    public Product selectProductById(int id);
}
