package api;

import Canvas.Canvas;
import Canvas.CanvasDAO;
import Epok.Epok;
import Studentits.Studentits;
import Epok.EpokDAO;
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
@Path("CanvasAPI")
public class CanvasAPI {

    @GET
    @Path("ping")
    public Response ping() {
        return Response
                .ok("ping ok canvasAPI")
                .build();
    }

    //hämta canvas list
    //http://localhost:27923/RegApp/webresources/CanvasAPI/canvas
    @GET
    @Path("canvas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsJson() {
        List<Canvas> c = new CanvasDAO().getCanvas();
        return Response.ok(c).build();
    }

}
