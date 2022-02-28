package com.registration.controller;

import com.registration.dao.DeleteDetails;
import com.registration.dbconnection.ConnectionProvider;
import com.registration.model.Party;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String partyId = req.getParameter("id");

        Party party = new Party();

        party.setPartyId(Integer.parseInt(partyId));        //set value in setPartyId() method of party class

        DeleteDetails deleteDetails = new DeleteDetails(ConnectionProvider.getConnection());        // reference variable is created for (dao) DeleteDetails

        if (deleteDetails.isDeleteDetails(party)) {       //in isDeleteDetails() sql delete operation will be performed

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Record Deleted Successfully');");
            out.println("</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile");
            requestDispatcher.include(req, resp);
            System.out.println("DeleteServlet successfully data delete");

        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("There is a problem in Deleting Record.');");
            out.println("</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile");
            requestDispatcher.include(req, resp);
            System.out.println(" failed data update");

        }

    }
}
