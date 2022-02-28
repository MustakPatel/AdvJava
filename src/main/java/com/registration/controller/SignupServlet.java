package com.registration.controller;

import com.registration.dao.PartyDao;
import com.registration.dao.UserLoginInsert;
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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

//        -------------------------parameters is being taken from SignUp.html page----------------

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String zip = req.getParameter("zip");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Party party = new Party();      // reference variable is created for (model) party

//        ----------------- value is being taken in party's setter --------------------------------------
        party.setFirstName(firstname);
        party.setLastName(lastname);
        party.setAddress(address);
        party.setCity(city);
        party.setState(state);
        party.setCountry(country);
        party.setZip(zip);
        party.setPhone(phone);


        PartyDao p = new PartyDao(ConnectionProvider.getConnection());
        int partyId = p.userID();

        UserLogin userLogin = new UserLogin();      // reference variable is created for (model) UserLogin

//        ----------------- value is being taken in UserLogin's setter --------------------------------------
        userLogin.setLoginId(email);
        userLogin.setPassword(password);
        userLogin.setPartyId(partyId);

        PartyDao partyDao = new PartyDao(ConnectionProvider.getConnection());       //PartyDao is a class where Insertion operation will be performed
        UserLoginInsert userLoginInsert = new UserLoginInsert(ConnectionProvider.getConnection());      //PartyDao is a class where Insertion operation will be performed
        if (partyDao.insertUser(party) && userLoginInsert.insertLoginData(userLogin)) {       //if both condition true

            System.out.println("successfull");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration successfull please login');");
            out.println("</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");        //its login page
            requestDispatcher.include(req, resp);
        } else {
            System.out.println("failed");
        }
    }
}
