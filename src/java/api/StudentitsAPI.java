/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Studentits.Studentits;
import Studentits.StudentitsDAO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nils Danielsen
 */
@Path("studentitsAPI")
public class StudentitsAPI {

    // test ping
    //http://localhost:27923/RegApp/webresources/studentitsAPI/ping
    @GET
    @Path("ping")
    public Response ping() {
        return Response
                .ok("ping ok studentitsAPI")
                .build();
    }

    //Hämta alla studenits  (List, Json)
    //http://localhost:27923/RegApp/webresources/studentitsAPI/students
    @GET
    //@Path("students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsJson() {
        List<Studentits> student = new StudentitsDAO().getStudents();
        return Response.ok(student).build();
    }

    //hämta instans av Studentits efter firstnamn 
    //http://localhost:27923/RegApp/webresources/studentitsAPI/firstname?firstName=Nils
    @Path("/firstname")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentByFirstName(@QueryParam("firstName") String firstName) {
        Studentits student = new StudentitsDAO().getStudentByFirstName1(firstName);
        return Response.ok(student).build();
    }

    // hämta instans av Studentits efter nameLtu
    //http://localhost:27923/RegApp/webresources/studentitsAPI/nameltu?nameltu=inadiz-1
    @Path("/nameltu")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentByLtunamn(@QueryParam("nameltu") String nameltu) {
        Studentits student = new StudentitsDAO().getStudentByLtuName(nameltu);
        return Response.ok(student).build();
    }
    
    
     
    // hämta personnr av Studentits efter nameLtu
    //http://localhost:27923/RegApp/webresources/studentitsAPI/nameltu?nameltu=inadiz-1
    //return ex string 199609111234
    @Path("/nameltu1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonNrByLtunamn1(@QueryParam("nameltu1") String nameltu1) {
        Studentits student = new StudentitsDAO().getStudentByLtuName(nameltu1);
        String firstname = student.getFirstname();
        return Response.ok(firstname).build();
    }

}
