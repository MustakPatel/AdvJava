package com.registration.controller;

import com.registration.dbconnection.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("SearchServlet");
        String name =req.getParameter("search");


        String sql = "SELECT * FROM userlogin u INNER JOIN party p ON u.partyId = p.partyId "+
                " WHERE p.firstName = '"+name+"' OR p.lastName = '"+name+"'";

        Connection connection = null;

        try {
            connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                out.println(resultSet.getInt("partyId"));
                out.println(resultSet.getString("firstName"));
                out.println(resultSet.getString("lastName"));
                out.println(resultSet.getString("address"));
                out.println(resultSet.getString("city"));
                out.println(resultSet.getString("state"));
                out.println(resultSet.getString("country"));
                out.println(resultSet.getString("zip"));
                out.println(resultSet.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
