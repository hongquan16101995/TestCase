package service;

import connection.ConnectionDBOfCustomer;
import connection.ConnectionDBOfProduct;
import model.Customer;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "service.RegistrationServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    ConnectionDBOfCustomer connectionDBOfCustomer = new ConnectionDBOfCustomer();
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);

    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "registration":
                registration(request, response);
                break;
            case "login":
                login(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("customer-account");
        String password = request.getParameter("customer-password");

        Customer customerCheck = connectionDBOfCustomer.selectCustomerByName(account);

        if (account.equals("admin") & password.equals("admin")) {
            List<Product> products = connectionDBOfProduct.selectAllProduct();
            request.setAttribute("listAllProduct", products);
            request.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_admin.jsp");
            dispatcher.forward(request, response);
        } else if(customerCheck == null){
            List<Product> products = connectionDBOfProduct.selectAllProduct();
            request.setAttribute("listAllProduct", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_login_not_done.jsp");
            dispatcher.forward(request, response);
        } else if (customerCheck.getAccount().equals(account)) {
            if(customerCheck.getPassword().equals(password)) {
                List<Product> products = connectionDBOfProduct.selectAllProduct();
                request.setAttribute("listAllProduct", products);
                request.setAttribute("account", account);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
                dispatcher.forward(request, response);
            }else {
                List<Product> products = connectionDBOfProduct.selectAllProduct();
                request.setAttribute("listAllProduct", products);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_login_not_done.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("customer-name");
        int age = Integer.parseInt(request.getParameter("customer-age"));
        String phone = request.getParameter("customer-phone");
        String render = request.getParameter("customer-gender");
        String email = request.getParameter("customer-email");
        String address = request.getParameter("customer-address");
        String account = request.getParameter("customer-acc");
        String password = request.getParameter("customer-pass");
        long millis = System.currentTimeMillis();
        java.sql.Date dateCreate = new java.sql.Date(millis);

        Customer customerCheck = connectionDBOfCustomer.selectCustomerByName(account);

        if (customerCheck != null) {
            List<Product> products = connectionDBOfProduct.selectAllProduct();
            request.setAttribute("listAllProduct", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_regis_not_done.jsp");
            dispatcher.forward(request, response);
        } else {
            Customer customer = new Customer(name, age, render, email, address, phone, account, password, dateCreate);
            connectionDBOfCustomer.insertCustomer(customer);
            List<Product> products = connectionDBOfProduct.selectAllProduct();
            request.setAttribute("listAllProduct", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_regis_done.jsp");
            dispatcher.forward(request, response);
        }
    }
}
