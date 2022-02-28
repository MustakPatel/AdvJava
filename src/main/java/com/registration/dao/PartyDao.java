package com.registration.dao;

import com.registration.model.Party;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// it is being used for inserting data in mysql : Party Table
public class PartyDao {

    private final Connection connection;

    public PartyDao(Connection connection) {
        this.connection = connection;
    }


    public int userID() {

        int primaryKey = 0;

        try {

            PreparedStatement ps = connection.prepareStatement("select Max(partyId) from javaproject.party");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                primaryKey = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return primaryKey + 1;
    }

    public boolean insertUser(Party party) {     //it will return boolean type value from here to SignupServlet

        boolean isUserDataInserted = false;
        int partyId = userID();

        try {

            String partySql = "INSERT INTO party(partyId, firstname, lastname, address, " +
                    "city, state, country,zip,phone) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(partySql);
            statement.setInt(1, partyId);        //value is being taken from userId() which is defined above
            statement.setString(2, party.getFirstName());        //value is being taken from (model) party class
            statement.setString(3, party.getLastName());     //value is being taken from (model) party class
            statement.setString(4, party.getAddress());      //value is being taken from (model) party class
            statement.setString(5, party.getCity());     //value is being taken from (model) party class
            statement.setString(6, party.getState());        //value is being taken from (model) party class
            statement.setString(7, party.getCountry());      //value is being taken from (model) party class
            statement.setString(8, party.getZip());      //value is being taken from (model) party class
            statement.setString(9, party.getPhone());        //value is being taken from (model) party class
            System.out.println("partyId :" + partyId);        //value is being taken from partyId variable

            statement.executeUpdate();

            isUserDataInserted = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUserDataInserted;
    }
}
