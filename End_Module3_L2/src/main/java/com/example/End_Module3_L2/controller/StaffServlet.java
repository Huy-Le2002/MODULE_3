package com.example.End_Module3_L2.controller;

import com.example.End_Module3_L2.dao.StaffDAO;
import com.example.End_Module3_L2.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/staff")
public class StaffServlet extends HttpServlet {
    StaffDAO staffDAO = new StaffDAO();
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
                    deleteStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "find":
                findData(request,response);
                break;
            case "edit":
                showEdit(request,response);
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
                    insertStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String groupstaff = request.getParameter("groupstaff");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phonenumber = request.getParameter("phonenumber");
        String cmnd = request.getParameter("cmnd");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Staff staff = new Staff(id,groupstaff, name,dob,phonenumber,cmnd,email,address);
        staffDAO.updateStaff(staff);
        request.setAttribute("message","Update success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<String> groupStaff = staffDAO.selectgroupstaff();
        Staff staff = staffDAO.selectStaff(id);
        request.setAttribute("groupStaff",groupStaff);
        request.setAttribute("data_staff",staff);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void insertStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String groupstaff = request.getParameter("groupstaff");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phonenumber = request.getParameter("phonenumber");
        String cmnd = request.getParameter("cmnd");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Staff staff = new Staff(groupstaff,name,dob,phonenumber,cmnd,email,address);
        staffDAO.insertStaff(staff);
        request.setAttribute("message","Create success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        dispatcher.forward(request, response);
    }

    private void findData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("key");

        List<Staff> list = staffDAO.searchLikeStaff(keyWord);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/find.jsp");
        requestDispatcher.forward(request,response);
    }
    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffDAO.deleteStaff(id);
        response.sendRedirect("/staff");
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = staffDAO.selectgroupstaff();
        request.setAttribute("groupData",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/create.jsp");
        requestDispatcher.forward(request,response);
    }



    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> list = staffDAO.selectAllStaff();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
