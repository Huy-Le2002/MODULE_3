package com.example.CaseStudy_Module3.controller;

import com.example.CaseStudy_Module3.dao.IUserDAO;
import com.example.CaseStudy_Module3.dao.UserDAO;
import com.example.CaseStudy_Module3.model.Country;
import com.example.CaseStudy_Module3.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object userLogin = request.getSession().getAttribute("user");
        if(userLogin == null){
            response.sendRedirect("/login");
        }else{
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    try {
                        insertUser(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        updateUser(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            }
        }

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int id_country = Integer.parseInt(request.getParameter("id_country"));
        User user = new User(id, name,email,id_country);
        userDAO.updateUser(user);
        request.setAttribute("message","Update success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int id_country = Integer.parseInt(request.getParameter("id_country"));
        User user = new User(name,email,id_country);
        userDAO.insertUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object userLogin = request.getSession().getAttribute("user");
        if(userLogin == null){
            response.sendRedirect("/login");
        }else{

            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    try {
                        deleteUser(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "sort":
                    sortUser(request,response);
                    break;
                case "find":
                    findLike(request,response);
                    break;
                default:
                    listUser(request,response);
            }
        }

    }

    private void findLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("key");

        List<User> list = userDAO.searchLikeUser(keyWord);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/find.jsp");
        requestDispatcher.forward(request,response);
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userDAO.sortUser();
        request.setAttribute("list",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("/user");
//        List<User> list = userDAO.selectAllUser();
//        request.setAttribute("list",list);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
//        requestDispatcher.forward(request,response);
    }

    private void  showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        User user = userDAO.selectUser(id);
        List<Country> country = userDAO.list();
        request.setAttribute("data_country",country);
//        Country country = userDAO.list(id);
        request.setAttribute("data_user",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void  showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Country> country = userDAO.list();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        request.setAttribute("data",country);
        requestDispatcher.forward(request,response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUser = userDAO.selectAllUser();
        request.setAttribute("list",listUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
