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
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();
    ConnectionDBOfCustomer connectionDBOfCustomer = new ConnectionDBOfCustomer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shirt":
                listShirt(request, response);
                break;
            case "trousers":
                listTrousers(request, response);
                break;
            case "shoes":
                listShoes(request, response);
                break;
            case "search":
                listSearch(request, response);
                break;
            case "add":
                addInCart(request, response);
                break;
            case "customer":
                myAccount(request, response);
                break;
            case "repassword":
                rePassword(request,response);
            default:
                listAllProduct(request, response);
                break;
        }
    }

    private void rePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        Customer customer = connectionDBOfCustomer.selectCustomerByName(account);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer_repassword.jsp");
        dispatcher.forward(request, response);
    }

    private void myAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        Customer customer = connectionDBOfCustomer.selectCustomerByName(account);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer_in_account.jsp");
        dispatcher.forward(request, response);
    }

    private void listShirt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        String type = request.getParameter("type");
        List<Product> products = connectionDBOfProduct.selectProductOfShirt(type);
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void listTrousers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        String type = request.getParameter("type");
        List<Product> products = connectionDBOfProduct.selectProductOfTrousers(type);
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void listShoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        String type = request.getParameter("type");
        List<Product> products = connectionDBOfProduct.selectProductOfShoes(type);
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void listSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        String regex = request.getParameter("regex");
        List<Product> products = connectionDBOfProduct.selectProductByName(regex);
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void addInCart(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        int id = Integer.parseInt(request.getParameter("id"));
    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        request.setAttribute("account", account);
        List<Product> products = connectionDBOfProduct.selectAllProduct();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/home_customer.jsp");
        dispatcher.forward(request, response);
    }
}
