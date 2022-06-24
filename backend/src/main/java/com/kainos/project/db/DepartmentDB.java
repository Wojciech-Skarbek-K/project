package com.kainos.project.db;

import com.kainos.project.api.models.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDB {
    public static List<Department> getDepartments() throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Department"
        );
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department(rs);
            departments.add(department);
        }
        rs.close();
        st.close();
        return departments;
    }

    public static int addDepartment(Department department) throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        String sql = "INSERT INTO Department" +
                "(dep_name) VALUES (\"" +
                department.getDep_name() + "\");";
        st.executeUpdate(sql);
        return 1;
    }
}
