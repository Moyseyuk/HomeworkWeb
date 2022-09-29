package com.tms.Lesson24.servlet;

import com.tms.Lesson24.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String access = LoginService.accessFilter(login, password);

        if (access.equals("admin")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/AddUser.html");
            requestDispatcher.forward(req, resp);
        } else if (access.equals("user")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ShowImage.html");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.html");
            requestDispatcher.forward(req, resp);
        }
    }
}
