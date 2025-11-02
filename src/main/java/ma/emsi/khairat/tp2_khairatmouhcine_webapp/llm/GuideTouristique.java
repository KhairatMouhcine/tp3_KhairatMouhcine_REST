package ma.emsi.khairat.tp2_khairatmouhcine_webapp.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;


public interface GuideTouristique {

    @SystemMessage("""
        Vous êtes un guide touristique.
        Lorsqu'on vous donne un nom de pays ou de ville, 
        vous indiquez les 2 principaux endroits à visiter 
        et le prix moyen d’un repas dans la devise locale.
        Répondez au format JSON suivant :
        {
          "ville_ou_pays": "nom du lieu",
          "endroits_a_visiter": ["endroit1", "endroit2"],
          "prix_moyen_repas": "<prix> <devise>"
        }
        N'utilisez pas Markdown.
    """)
    String getInfos(@UserMessage String lieu);
}