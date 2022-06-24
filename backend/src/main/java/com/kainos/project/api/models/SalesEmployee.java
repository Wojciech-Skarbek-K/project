package com.kainos.project.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesEmployee {
    private short sal_id;
    private short emp_id;
    private double com_rate;
    private int sal_rate;

    @JsonCreator
    public SalesEmployee(
            @JsonProperty("sal_id") short sal_id,
            @JsonProperty("emp_id") short emp_id,
            @JsonProperty("com_rate") double com_rate,
            @JsonProperty("sal_rate") int sal_rate
    ) {
        this.sal_id = sal_id;
        this.emp_id = emp_id;
        this.com_rate = com_rate;
        this.sal_rate = sal_rate;
    }

    public SalesEmployee(ResultSet rs) throws SQLException {
        this(
                rs.getShort("sal_id"),
                rs.getShort("emp_id"),
                rs.getDouble("com_rate"),
                (int)rs.getDouble("sal_rate")
        );
    }

    public short getSal_id() {
        return sal_id;
    }

    public short getEmp_id() {
        return emp_id;
    }

    public double getCom_rate() {
        return com_rate;
    }

    public int getSal_rate() {
        return sal_rate;
    }
}
