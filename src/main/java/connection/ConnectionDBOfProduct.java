package connection;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDBOfProduct implements ConnectionDBProduct {

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product"
            + "(name_product, productType, price_product, description_product, imageUrl_product) VALUES "
            + " (?, ?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name_product LIKE ?";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    private static final String SELECT_ALL_PRODUCT_OF_TYPE = "SELECT * FROM product WHERE productType = ?";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET name_product = ?,productType = ?, price_product = ?, " +
            "description_product = ?, imageUrl_product = ? WHERE id = ?;";
    private static final Connection connection = new ConnectionDBOfCustomer().getConnection();

    public ConnectionDBOfProduct() {
    }

    private void setValueOfCustomer(Product product, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getProductType());
        preparedStatement.setLong(3, product.getPrice());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setString(5, product.getImageUrl());
    }

    @Override
    public void insertProduct(Product product) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            setValueOfCustomer(product, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdated = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getProductType());
            preparedStatement.setLong(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImageUrl());
            preparedStatement.setInt(6, product.getID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectProductByName(String regex) {
        List<Product> products = new ArrayList<>();
        String regexString = "%" + regex + "%";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, regexString);
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product selectProductByCode(int id) {
        return null;
    }

    @Override
    public Product selectProductById(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name_product");
                String type = rs.getString("productType");
                long price = rs.getLong("price_product");
                String description = rs.getString("description_product");
                String imageUrl = rs.getString("imageUrl_product");
                product = new Product(name, type, price, description, imageUrl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectProductOfShirt() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_OF_TYPE)) {
            preparedStatement.setString(1, "Áo");
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectProductOfTrousers() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_OF_TYPE)) {
            preparedStatement.setString(1, "Quần");
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectProductOfShoes() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_OF_TYPE)) {
            preparedStatement.setString(1, "Giày");
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void getListProduct(List<Product> products, PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name_product");
            String type = rs.getString("productType");
            long price = rs.getLong("price_product");
            String description = rs.getString("description_product");
            String imageUrl = rs.getString("imageUrl_product");
            products.add(new Product(id, name, type, price, description, imageUrl));
        }
    }
}