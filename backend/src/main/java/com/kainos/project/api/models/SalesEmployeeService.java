package com.kainos.project.api.models;

import com.kainos.project.db.SalesEmployeeDB;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("Sales Employee API")
public class SalesEmployeeService {
    @GET
    @Path("/salesEmployees")
    @Produces({MediaType.APPLICATION_JSON})
    public List<SalesEmployee> getSalesEmployees() throws SQLException {
        return SalesEmployeeDB.getSalesEmployee();
    }

    @POST
    @Path("/salesEmployees")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public int addSalesEmployee(SalesEmployee salesEmployee) throws SQLException {
        return SalesEmployeeDB.addSalesEmployee(salesEmployee);
    }
}
