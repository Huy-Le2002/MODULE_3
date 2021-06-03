package com.example.STUDENT_ADVANCED.controller;

import com.example.STUDENT_ADVANCED.dao.StudentDAO;
import com.example.STUDENT_ADVANCED.model.Specialized;
import com.example.STUDENT_ADVANCED.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "delete":
                try {
                    deleteStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "find":
                findStudent(request,response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudent(id);
        List<Specialized> list = studentDAO.list();
        request.setAttribute("data_spe",list);
        request.setAttribute("data_student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
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
                    insertUser(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "edit":
                try {
                    updateStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int specialized_id = Integer.parseInt(request.getParameter("specialized_id"));
        Student student = new Student(id, name,age,specialized_id);
        studentDAO.updateStudent(student);
        request.setAttribute("message","Update success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("key");

        List<Student> list = studentDAO.searchLikeStudent(keyWord);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/find.jsp");
        requestDispatcher.forward(request,response);
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect("/student");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int specialized_id = Integer.parseInt(request.getParameter("specialized_id"));
        Student student = new Student(name,age,specialized_id);
        studentDAO.insertStudent(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Specialized> list = studentDAO.list();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("data",list);
        requestDispatcher.forward(request,response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> listUser = studentDAO.selectAllStudent();
        request.setAttribute("list",listUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
