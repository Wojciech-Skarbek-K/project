package com.kainos.project.api;

import com.kainos.project.api.models.Employee;
import com.kainos.project.db.EmployeeDB;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("Employee API")
public class EmployeesService {
    @GET
    @Path("/employees")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> getEmployees() throws SQLException {
        return EmployeeDB.getEmployees();
    }

    @GET
    @Path("/employees/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Employee getEmployeeById(@PathParam("id") short id) throws SQLException {
        return EmployeeDB.getEmployeeById(id);
    }

    @GET
    @Path("/employees/dep/{dep_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> getEmployeesByDep(@PathParam("dep_id") short dep_id) throws SQLException {
        return EmployeeDB.getEmployeesByDep(dep_id);
    }

    @POST
    @Path("/employees")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public int addEmployee(Employee employee) throws SQLException {
        return EmployeeDB.addEmployee(employee);
    }
}
