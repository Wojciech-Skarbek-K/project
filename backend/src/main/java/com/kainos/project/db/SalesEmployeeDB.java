package com.kainos.project.db;

import com.kainos.project.api.models.Employee;
import com.kainos.project.api.models.SalesEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDB {
    public static List<SalesEmployee> getSalesEmployee() throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Sales_Employee;");
        List<SalesEmployee> salesEmployees = new ArrayList<>();
        while (rs.next()) {
            SalesEmployee salesEmployee = new SalesEmployee(rs);
            salesEmployees.add(salesEmployee);
        }
        rs.close();
        st.close();
        return salesEmployees;
    }

    public static int addSalesEmployee(SalesEmployee salesEmployee) throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        String sql = "INSERT INTO Sales_Employee" +
                "(emp_id, com_rate, sal_rate) VALUES (" +
                salesEmployee.getEmp_id() + ", " +
                salesEmployee.getCom_rate() / 100 + ", " +
                salesEmployee.getSal_rate() / 100 + ");";
        st.executeUpdate(sql);
        return 1;
    }

    public static SalesEmployee getHighestSalesEmployee() throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Sales_Employee WHERE sal_rate = (SELECT MAX(sal_rate) FROM Sales_Employee);"
        );
        rs.next();
        SalesEmployee employee = new SalesEmployee(rs);
        rs.close();
        st.close();
        return employee;
    }
}
