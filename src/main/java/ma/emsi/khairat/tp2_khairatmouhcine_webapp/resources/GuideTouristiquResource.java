package ma.emsi.khairat.tp2_khairatmouhcine_webapp.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiquResource {
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("text/plain")
    public String getInfos(@PathParam("ville_ou_pays") String lieu) {
        return lieu;
    }
}
