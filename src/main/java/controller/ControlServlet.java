package controller;

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

@WebServlet(name = "ControlServlet", urlPatterns = "/control")
public class ControlServlet extends HttpServlet {
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editProduct":
                    editProduct(request,response);
                break;
            case "addInCart":
//                addInCart(request, response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("product-name");
        String type = request.getParameter("product-type");
        long price = Long.parseLong(request.getParameter("product-price"));
        String description = request.getParameter("product-description");
        String imageUrl = request.getParameter("product-imageUrl");
        Product product = new Product(id, name, type, price, description, imageUrl);
        connectionDBOfProduct.updateProduct(product);
        List<Product> products = connectionDBOfProduct.selectAllProduct();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home_admin.jsp");
        requestDispatcher.forward(request, response);
    }
}
