package com.example.Customer.controller;

import com.example.Customer.model.Product;
import com.example.Customer.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertProduct(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateProduct(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String des = request.getParameter("des");
        String producer = request.getParameter("producer");
        Product product = productService.findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setDes(des);
        product.setProducer(producer);
        productService.update(id,product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("data",product);
        request.setAttribute("message","Product information was updated");
        requestDispatcher.forward(request,response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String des = request.getParameter("des");
        String producer = request.getParameter("producer");
        int id = (int)(Math.random() * 10000);
        Product product = new Product(id,name,price,des,producer);
        productService.save(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","New product was created");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreate(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                try {
                    showInfor(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEdit(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    showDelete(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listProduct(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
//        List<Product> list = productService.list();
//        request.setAttribute("data",list);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
//        requestDispatcher.forward(request,response);
        response.sendRedirect("product");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("data",product);
        requestDispatcher.forward(request,response);
    }

    private void showInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/view.jsp");
        request.setAttribute("data",product);
        requestDispatcher.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.list();
        request.setAttribute("data",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
