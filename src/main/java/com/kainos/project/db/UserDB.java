package com.kainos.project.db;

import com.kainos.project.api.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static List<User> getUsers() throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM User;");
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User(rs);
            users.add(user);
        }
        rs.close();
        st.close();
        System.out.println(users);
        return users;
    }



public static User getUser(String login) throws SQLException {
    Connection c = DB.getConnection();
    System.out.println("\n\n\n" + login);
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(
            "SELECT * "
                    + "FROM User "
                    + "WHERE login = " + "'" + login + "'" + ";");
    rs.next();
    User user = new User(rs);
    rs.close();
    st.close();
    return user;
    }
}
