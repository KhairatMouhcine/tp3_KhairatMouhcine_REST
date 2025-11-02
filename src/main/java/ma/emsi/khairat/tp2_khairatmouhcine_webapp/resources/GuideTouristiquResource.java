package ma.emsi.khairat.tp2_khairatmouhcine_webapp.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiquResource {
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[]  getInfos(@PathParam("ville_ou_pays") String lieu) {
        // Retourne un tableau contenant un seul élément : le nom du lieu
        return new String[]{lieu};
    }
}
