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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ConnectionDBOfProduct connectionDBOfProduct = new ConnectionDBOfProduct();

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
            case "create":
//                    showNewForm(request, response);
                break;
            case "addInCart":
//                addInCart(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProductById(request, response);
                break;
            case "shirt":
                listProductOfShirt(request, response);
                break;
            case "trousers":
                listProductOfTrousers(request, response);
                break;
            case "shoes":
                listProductOfShoes(request, response);
                break;
            case "searchHome":
                searchProductByNameInHome(request, response);
                break;
            case "searchCustomer":
                searchProductByName(request, response);
                break;
            default:
                listAllProduct(request, response);
                break;
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regex = request.getParameter("regex");
        String account = request.getParameter("account");
        List<Product> products = connectionDBOfProduct.selectProductByName(regex);
        request.setAttribute("listAllProduct", products);
        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void searchProductByNameInHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regex = request.getParameter("regex");
        List<Product> products = connectionDBOfProduct.selectProductByName(regex);
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/demo.jsp");
        dispatcher.forward(request, response);
    }

    private void listProductOfShoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = connectionDBOfProduct.selectProductOfShoes();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/demo.jsp");
        dispatcher.forward(request, response);
    }

    private void listProductOfTrousers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = connectionDBOfProduct.selectProductOfTrousers();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/demo.jsp");
        dispatcher.forward(request, response);
    }

    private void listProductOfShirt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = connectionDBOfProduct.selectProductOfShirt();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/demo.jsp");
        dispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = connectionDBOfProduct.selectProductById(id);
        request.setAttribute("product", product);
        List<Product> products = connectionDBOfProduct.selectAllProduct();
        request.setAttribute("listAllProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home_admin_edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProductById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        connectionDBOfProduct.deleteProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    }

}
