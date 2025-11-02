package ma.emsi.khairat.tp2_khairatmouhcine_webapp.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.khairat.tp2_khairatmouhcine_webapp.llm.LlmClientForGuide;

@Path("/guide")

public class GuideTouristiquResource {

    @Inject
    private LlmClientForGuide llmClient;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String  getInfos(@PathParam("ville_ou_pays") String lieu) {
        // Appel au modèle Gemini via LangChain4j
        return llmClient.getInfos(lieu);
    }
}
