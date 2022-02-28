package com.registration.controller;

import com.registration.dao.CheckLogin;
import com.registration.dbconnection.ConnectionProvider;
import com.registration.model.UserLogin;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserLogin userLogin = new UserLogin();
        userLogin.setLoginId(email);
        userLogin.setPassword(password);

        CheckLogin checkLogin = new CheckLogin(ConnectionProvider.getConnection());
        HttpSession httpSession = req.getSession(true);

        if (checkLogin.isValidateData(userLogin)) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Login successfull');");
            out.println("</script>");

            httpSession.setAttribute("userName", userLogin.getLoginId());
            httpSession.setMaxInactiveInterval(2);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile");
            requestDispatcher.include(req, resp);
            System.out.println("it's work");

        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect please try again!');");
            out.println("</script>");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");        //it's login page
            requestDispatcher.include(req, resp);
            System.out.println("its not work");
        }
    }
}
