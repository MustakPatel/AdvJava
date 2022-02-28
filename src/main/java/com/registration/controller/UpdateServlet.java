package com.registration.controller;

import com.registration.dao.UpdateDetails;
import com.registration.dbconnection.ConnectionProvider;
import com.registration.model.Party;
import com.registration.model.UserLogin;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String partyId = req.getParameter("partyId");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String zip = req.getParameter("zip");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        Party party = new Party();
        UserLogin userLogin = new UserLogin();
        party.setPartyId(Integer.parseInt(partyId));
        party.setFirstName(firstName);
        party.setLastName(lastName);
        party.setAddress(address);
        party.setCity(city);
        party.setState(state);
        party.setCountry(country);
        party.setZip(zip);
        party.setPhone(phone);
        userLogin.setLoginId(email);

        UpdateDetails updateDetails = new UpdateDetails(ConnectionProvider.getConnection());

        if (updateDetails.isUpdateDetails(party, userLogin)) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Record Updated Successfully');");
            out.println("</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile");
            requestDispatcher.include(req, resp);
            System.out.println("UpdateServlet successfully data update");

        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("There is a problem in updating Record.');");
            out.println("</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Update.jsp");
            requestDispatcher.include(req, resp);
            System.out.println(" failed data update");

        }

    }
}
