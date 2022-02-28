package com.registration.dao;

import com.registration.model.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserLoginInsert {

    Connection connection;

    public UserLoginInsert(Connection connection) {

        this.connection = connection;
    }

    public boolean insertLoginData(UserLogin user) {

        boolean isDataInserted = false;

        try {

            String userSql = "INSERT INTO userlogin(userLoginId, password, partyId)" +
                    "VALUES(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(userSql);
            statement.setString(1, user.getLoginId());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getPartyId());

            statement.executeUpdate();
            isDataInserted = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDataInserted;
    }
}
