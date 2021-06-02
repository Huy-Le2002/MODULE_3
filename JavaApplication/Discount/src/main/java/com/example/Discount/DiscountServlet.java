package com.example.Discount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float discount = Float.parseFloat(request.getParameter("discount"));
        double price = Double.parseDouble(request.getParameter("price"));
        double DiscountAmount = discount * price * 0.01;
        double rs = price - DiscountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Discount Amount: " + discount);
        writer.println("</br>");
        writer.println("Discount Price: " + rs);
        writer.println("<html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
