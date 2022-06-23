package com.kainos.project.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
    private static Connection conn;

    protected static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            FileInputStream propsStream =
                    new FileInputStream("db.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");
            System.out.println(user);

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, an host properties.");

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/front_PatrykK?allowPublicKeyRetrieval=true&useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
