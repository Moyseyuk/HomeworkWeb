package com.tms.Lesson24.servlet;

import com.tms.Lesson24.services.RegisterUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUser")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String description = req.getParameter("description");
        String role = req.getParameter("role");

        String registerUser = RegisterUserService.addUser(login, password, sex, description, role);
        if (registerUser.equals("error")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.html");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EntryPage.html");
            requestDispatcher.forward(req, resp);
        }

    }
}
