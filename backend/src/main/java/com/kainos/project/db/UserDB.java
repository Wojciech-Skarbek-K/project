package com.kainos.project.db;

import com.kainos.project.api.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static String addUser(User user) {
        try {
            Connection c = DB.getConnection();
            Statement st = c.createStatement();
            String sql = "INSERT INTO User" +
                    "(login, password, dep_id) VALUES (" +
                    "\"" + user.getLogin() + "\"," +
                    "\"" + user.getPassword() + "\"," +
                    user.getDep_id() + ");";
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            return "Couldn't add user to database: " + e;
        } catch (NullPointerException e) {
            return "Couldn't add user: " + e.getMessage();
        }
        return "User " + user.getLogin() + " successfully added!";
    }

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
        return users;
    }



public static User getUser(String login) throws SQLException {
    Connection c = DB.getConnection();
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
