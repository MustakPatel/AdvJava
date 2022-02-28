package com.registration.dao;

import com.registration.model.Party;
import com.registration.model.UserLogin;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/DisplayData")
public class DisplayData {

    Connection connection;
    Party partyEntity = new Party();
    UserLogin userLoginEntity = new UserLogin();

    public DisplayData(Connection connection) {     //connection will be initialized by ConnectionProvider class
        this.connection = connection;
    }

    public boolean isDataDisplay() {

        boolean showData = false;

        try {

            String sql = " SELECT p.partyId, firstName, lastName, address, city," +
                    " zip, state, country, phone,userLoginId FROM party p," +
                    " userlogin u WHERE p.partyId = u.partyId";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                partyEntity.setPartyId(resultSet.getInt(1));
                partyEntity.setFirstName(resultSet.getString(2));
                partyEntity.setLastName(resultSet.getString(3));
                partyEntity.setAddress(resultSet.getString(4));
                partyEntity.setCity(resultSet.getString(5));
                partyEntity.setZip(resultSet.getString(6));
                partyEntity.setState(resultSet.getString(7));
                partyEntity.setCountry(resultSet.getString(8));
                partyEntity.setPhone(resultSet.getString(9));
                userLoginEntity.setLoginId(resultSet.getString(10));

            }

            showData = true;

        } catch (Exception e) {

            System.out.println(e);
            ;
        }

        return showData;
    }

}

