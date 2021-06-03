package com.example.STUDENT_NORMAL.controller;

import com.example.STUDENT_NORMAL.dao.StudentDAO;
import com.example.STUDENT_NORMAL.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/student")
public class StudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                try {
                    deleteStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                showList(request,response);
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
                    insertStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect("/student");
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String specialized = request.getParameter("specialized");
        Student student = new Student(id,name,age,specialized);
        studentDAO.updateStudent(student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudent(id);
        request.setAttribute("data",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String specialized = request.getParameter("specialized");
        Student student = new Student(name,age,specialized);
        studentDAO.insertStudent(student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentDAO.selectAllStudent();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("data",list);
        requestDispatcher.forward(request,response);
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);
    }
}
