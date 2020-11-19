package api;

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
@Path("EpokAPI")
public class EpokAPI {

    @GET
    @Path("ping")
    public Response ping() {
        return Response
                .ok("ping ok epokAPI")
                .build();
    }

    //hämta epok list
    //http://localhost:27923/RegApp/webresources/EpokAPI/epoks
    @GET
    @Path("epoks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsJson() {
        List<Epok> epoks = new EpokDAO().getEpoks();
        return Response.ok(epoks).build();
    }

    //hämta epok list efter kurskod
    //http://localhost:27923/RegApp/webresources/EpokAPI/kurskod?kurskod=D0025E
    @Path("/kurskod")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEpokByKursKod(@QueryParam("kurskod") String kurskod) {
        List<Epok> epoks = new EpokDAO().getEpokByKurskod(kurskod);
        return Response.ok(epoks).build();
    }

}
