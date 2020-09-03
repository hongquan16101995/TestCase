package service;

import connection.ConnectionDBOfCustomer;
import connection.ConnectionDBOfProduct;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "service.RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    ConnectionDBOfCustomer connectionDBOfCustomer = new ConnectionDBOfCustomer();
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = request.getParameter("customer-name");
//        int age = Integer.parseInt(request.getParameter("customer-age"));
//        String phone = request.getParameter("customer-phone");
//        String render = request.getParameter("customer-gender");
//        String email = request.getParameter("customer-email");
//        String address = request.getParameter("customer-address");
//
//        if(name != "") {
//            Customer customer = new Customer(name, age, render, email, address, phone);
//            connectionDBOfCustomer.insertCustomer(customer);
//        }else {
//            PrintWriter out = response.getWriter();
//            out.println("Lỗi");
//        }

        String name = request.getParameter("customer-name");
        String type = (request.getParameter("customer-type"));
        long price = Long.parseLong(request.getParameter("customer-price"));
        String description = request.getParameter("customer-description");
        String image = request.getParameter("customer-image");


            Product product = new Product(name, type, price, description, image);
            connectionDBOfProduct.insertProduct(product);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        connectionDBOfProduct.deleteProduct(1);
        Product product = connectionDBOfProduct.selectProductById(3);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("display1product.jsp");
        dispatcher.forward(request, response);
    }
}
