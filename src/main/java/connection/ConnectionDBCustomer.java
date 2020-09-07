package connection;

import model.Customer;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ConnectionDBCustomer {
    public void insertCustomer(Customer customer) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public boolean updatePasswordCustomer(String account, String newpassword) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;

    public List<Customer> selectAllCustomer();

    public Customer selectCustomerByName(String account);

    public boolean addInCart(Product product);
}
