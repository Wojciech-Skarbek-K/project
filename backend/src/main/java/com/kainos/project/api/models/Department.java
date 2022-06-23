package com.kainos.project.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.units.qual.A;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    short dep_id;
    String dep_name;

    @JsonCreator
    public Department(
            @JsonProperty("dep_id") short dep_id,
            @JsonProperty("emp_name") String dep_name
    ) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
    }

    public Department(ResultSet rs) throws SQLException {
        this(
                rs.getShort("dep_id"),
                rs.getString("dep_name")
        );
    }

    public short getDep_id() {
        return dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }
}
