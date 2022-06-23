package com.kainos.project.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String login;
    private String password;
    private short dep_id;

    @JsonCreator
    public User(
            @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("dep_id") short dep_id
    ) {
        this.login = login;
        this.password = password;
        this.dep_id = dep_id;
    }

    public User(ResultSet rs) throws SQLException {
        this(
                rs.getString("login"),
                rs.getString("password"),
                rs.getShort("dep_id")
        );
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public short getDep_id() {
        return dep_id;
    }
}
