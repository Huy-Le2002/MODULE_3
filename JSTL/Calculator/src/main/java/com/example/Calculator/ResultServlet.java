package com.example.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultServlet", value = "/ResultServlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("input1"));
        float second = Float.parseFloat(request.getParameter("input2"));
        char choose = request.getParameter("choose").charAt(0);
//        String choose = request.getParameter("choose");
        float rs = Calculator.calculate(first,second,choose);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h2>Result:</h2>");
        writer.println(first + " " + choose + " " + second + " = " + rs );
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
