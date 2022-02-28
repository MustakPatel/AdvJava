package com.registration.controller;

import com.registration.dao.DisplayData;
import com.registration.dbconnection.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class HomeProfilePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

//------------------------------use for showing data on Homepage------------------------------------

        DisplayData displayData = new DisplayData(ConnectionProvider.getConnection());      //it's class where i wrote sql operation

        if (displayData.isDataDisplay()) {        //if condition true it means data is being Displayed
            System.out.println("successfull data display");
        } else {
            System.out.println("Data is not showing");
        }
//-------------------------use for checking session--------------------------------------------

        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) {

            String mail = (String) httpSession.getAttribute("userName");
            System.out.println(mail);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("HomePage.jsp");     //(HomePage.jsp)it's main profile page
            requestDispatcher.include(req, resp);
            System.out.println("again come in HomePage");

        } else {
            out.println("please login first");
            System.out.println("session is not working");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");       //(index.jsp) it's login page
            requestDispatcher.include(req, resp);

        }
    }
}
