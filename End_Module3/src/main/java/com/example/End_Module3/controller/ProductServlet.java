package com.example.End_Module3.controller;

import com.example.End_Module3.dao.ProductDAO;
import com.example.End_Module3.model.Category;
import com.example.End_Module3.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showInsertProduct(request,response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            case "delete":
                try {
                    deleteProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            case "find":
                findProduct(request,response);
                break;
            default:
                listAllProduct(request,response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        List<Product> list = productDAO.findData(key);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/find.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id,name,price,quantity,color,des,category);
        productDAO.updateProduct(product);
        request.setAttribute("message","Update success");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        requestDispatcher.forward(request,response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            productDAO.deleteProduct(id);
            List<Product> list = productDAO.selectAllProduct();
            request.setAttribute("list",list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
            requestDispatcher.forward(request,response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        List<Category> list = productDAO.selectAllCategory();
        request.setAttribute("data_category",list);
        request.setAttribute("data_product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,quantity,color,category);
        productDAO.insertProduct(product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","Add thành công");
        requestDispatcher.forward(request,response);

    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.selectAllProduct();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showInsertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("data",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request,response);
    }
}
