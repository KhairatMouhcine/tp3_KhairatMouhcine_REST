package ma.emsi.khairat.tp2_khairatmouhcine_webapp.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.khairat.tp2_khairatmouhcine_webapp.llm.LlmClientForGuide;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuide llmClient;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json; charset=UTF-8")
    public String  getInfos(@PathParam("ville_ou_pays") String lieu,
                            @QueryParam("nb") Integer nbEndroits) {

        if(nbEndroits==null ){
            nbEndroits=0;
        }

        // Construire la requête envoyée au LLM
        String requete = lieu + " (" + nbEndroits + " endroits à visiter)";

        return llmClient.getInfos(requete);
    }
}
