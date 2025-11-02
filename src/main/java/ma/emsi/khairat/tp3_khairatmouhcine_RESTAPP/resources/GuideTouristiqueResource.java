package ma.emsi.khairat.tp3_khairatmouhcine_RESTAPP.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import ma.emsi.khairat.tp3_khairatmouhcine_RESTAPP.llm.LlmClientForGuide;

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
