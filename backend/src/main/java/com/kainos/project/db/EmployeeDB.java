package com.kainos.project.db;

import com.kainos.project.api.models.Employee;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDB {

    public static List<Employee> getEmployees() throws SQLException {
        Connection c = DB.getConnection();
        System.out.println(c+"\n\n\n");
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Employee;");
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee(rs);
            employees.add(employee);
        }
        rs.close();
        st.close();
        return employees;
    }

    public static Employee getEmployeeById(int emp_id) throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        System.out.println(emp_id);
        ResultSet rs = st.executeQuery(
          "SELECT * FROM Employee WHERE emp_id=" + emp_id +";"
        );
        rs.next();
        Employee employee = new Employee(rs);
        rs.close();
        st.close();
        return employee;
    }

    public static List<Employee> getEmployeesByDep(short dep_id) throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Employee WHERE dep_id=" + dep_id
        );
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee(rs);
            employees.add(employee);
        }
        rs.close();
        st.close();
        return employees;
    }

    public static int addEmployee(Employee employee) throws SQLException {
        Connection c = DB.getConnection();
        Statement st = c.createStatement();
        String sql = "INSERT INTO Employee" +
                "(emp_name, address, nin, ban, salary, dep_id) VALUES (" +
                "\"" + employee.getEmp_name() + "\"," +
                "\"" + employee.getAddress() + "\"," +
                "\"" + employee.getNin() + "\"," +
                "\"" + employee.getBan() + "\"," +
                employee.getSalary()/100 + "," +
                employee.getDep_id() + ");";
        System.out.println(sql);
        st.executeUpdate(sql);
        return 1;
    }
}
