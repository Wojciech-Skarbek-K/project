package com.kainos.project.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private int emp_id;
    private String emp_name;
    private String address;
    private String nin;
    private String bank;
    private int salary; // divided by 100

    private short dep_id;

    @JsonCreator
    public Employee(
            @JsonProperty("emp_id") int emp_id,
            @JsonProperty("emp_name") String emp_name,
            @JsonProperty("address") String address,
            @JsonProperty("nin") String nin,
            @JsonProperty("bank") String bank,
            @JsonProperty("salary") int salary,
            @JsonProperty("dep_id") short dep_id
    ) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.address = address;
        this.nin = nin;
        this.bank = bank;
        this.salary = salary;
        this.dep_id = dep_id;
    }

    public Employee(ResultSet rs) throws SQLException {
        this(
                rs.getShort("emp_id"),
                rs.getString("emp_name"),
                rs.getString("address"),
                rs.getString("nin"),
                rs.getString("ban"),
                (int)(rs.getDouble("salary")*100),
                rs.getShort("dep_id")
        );
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getAddress() {
        return address;
    }

    public String getNin() {
        return nin;
    }

    public String getBank() {
        return bank;
    }

    public int getSalary() {
        return salary;
    }

    public short getDep_id() {
        return dep_id;
    }
}
