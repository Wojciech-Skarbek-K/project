package com.kainos.project.api;

import com.kainos.project.api.models.Department;
import com.kainos.project.db.DepartmentDB;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("Department API")
public class DepartmentService {

   @GET
   @Path("/departments")
   @Produces({MediaType.APPLICATION_JSON})
   public List<Department> getDepartments() throws SQLException {
       return DepartmentDB.getDepartments();
   }

   @POST
   @Path("/departments")
   @Consumes({MediaType.APPLICATION_JSON})
   public int addDepartment(Department department) throws SQLException {
      return DepartmentDB.addDepartment(department);
   }

}
