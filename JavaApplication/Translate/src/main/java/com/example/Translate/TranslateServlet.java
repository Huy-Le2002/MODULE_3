package com.example.Translate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/TranslateServlet")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","Xin chào");
        dictionary.put("goodbye","Tạm biệt");
        dictionary.put("love you","Yêu bạn");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String rs = dictionary.get(search);
        if (rs != null) {
            writer.println("Word: " + search);
            writer.println("</br>");
            writer.println("Result " + rs);
        } else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
