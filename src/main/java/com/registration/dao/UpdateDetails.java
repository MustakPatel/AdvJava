package com.registration.dao;

import com.registration.controller.UpdateServlet;
import com.registration.model.Party;
import com.registration.model.UserLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDetails {

    Connection connection;

    UpdateServlet updateServlet = new UpdateServlet();

    public UpdateDetails(Connection connection) {
        this.connection = connection;
    }

    public boolean isUpdateDetails(Party party, UserLogin userLogin) {

        boolean updatedData = false;

        try {

            String partySql = "UPDATE party SET partyId=?, firstName=?, lastName=?, address=?," +
                    " city=?, zip=?, state=?, country=?, phone=? " +
                    "WHERE partyId =" + party.getPartyId();

            String userSql = "UPDATE userlogin SET userLoginId=? WHERE partyId =" + party.getPartyId();
            PreparedStatement statement1 = connection.prepareStatement(partySql);
            PreparedStatement statement2 = connection.prepareStatement(userSql);

            statement1.setInt(1, party.getPartyId());
            statement1.setString(2, party.getFirstName());
            statement1.setString(3, party.getLastName());
            statement1.setString(4, party.getAddress());
            statement1.setString(5, party.getCity());
            statement1.setString(6, party.getZip());
            statement1.setString(7, party.getState());
            statement1.setString(8, party.getCountry());
            statement1.setString(9, party.getPhone());
            statement2.setString(1, userLogin.getLoginId());

            int i = statement1.executeUpdate();
            int j = statement2.executeUpdate();

            if (i > 0 && j > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("There is a problem in updating Record.");
            }
            updatedData = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return updatedData;
    }
}
