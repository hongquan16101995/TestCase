package service;

import connection.ConnectionDBOfProduct;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/home")
public class MainServlet extends HttpServlet {
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = connectionDBOfProduct.selectAllProduct();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = connectionDBOfProduct.selectAllProduct();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo.jsp");
        dispatcher.forward(request, response);
    }
}
