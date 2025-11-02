# 🧭 TP3 – Application REST avec LangChain4j et Gemini

## 📘 Description du projet
Ce projet illustre la création d’une **application REST Jakarta EE** (Payara 6, Java 21) qui interagit avec le **modèle Gemini** de Google via **LangChain4j**.  
L’objectif est de simuler un **guide touristique intelligent** capable de fournir :  
- Les principaux lieux à visiter d’une ville ou d’un pays.  
- Le prix moyen d’un repas dans la devise locale.  

---

## 🧱 Structure du projet

```
src/
 └── main/java/ma/emsi/khairat/tp3_khairatmouhcine_RESTAPP/
      ├── RestApplication.java
      ├── HelloResource.java
      ├── llm/
      │   ├── GuideTouristique.java
      │   └── LlmClientForGuide.java
      └── resources/
          └── GuideTouristiqueResource.java
```

---

## ⚙️ Fonctionnement général

### Endpoint principal :
```
GET /api/guide/lieu/{ville_ou_pays}?nb={nombre_endroits}
```
- `ville_ou_pays` : nom de la ville ou du pays.  
- `nb` *(optionnel)* : nombre d’endroits à visiter.  

Si `nb` n’est pas précisé, la valeur `0` est utilisée par défaut.

### Exemple d’URL :
```
http://localhost:8080/tp3_khairatMouhcine_restapp-1.0-SNAPSHOT/api/guide/lieu/Maroc?nb=3
```

### Exemple de réponse JSON :
```
{
  "ville_ou_pays": "Maroc",
  "endroits_a_visiter": ["Marrakech", "Fès", "Chefchaouen"],
  "prix_moyen_repas": "80 MAD"
}
```

---

## 🧩 Classes principales

### 🔹 RestApplication.java
Configure la racine REST :  
```java
@ApplicationPath("/api")
public class RestApplication extends Application {}
```

### 🔹 HelloResource.java
Exemple simple pour tester JAX-RS :  
```java
GET /api/hello/personnes/Mouhcine → "Hello, Mouhcine!"
```

### 🔹 GuideTouristique.java
Interface définissant le rôle du LLM Gemini.  
Le message système impose la structure JSON et interdit le Markdown.

### 🔹 LlmClientForGuide.java
Gère la connexion au modèle Gemini :  
- Modèle utilisé : `gemini-2.5-flash`
- Mémoire : `MessageWindowChatMemory` (10 derniers messages)
- Clé API : variable d’environnement `GEMINI_KEY`

### 🔹 GuideTouristiqueResource.java
Classe REST exposant l’endpoint `/api/guide/lieu/{ville_ou_pays}`  
Utilise `@QueryParam("nb")` pour le nombre d’endroits à visiter et retourne une réponse JSON encodée en UTF-8.

---

## 🧰 Dépendances principales (pom.xml)

| Bibliothèque | Version | Description |
|--------------|----------|-------------|
| `jakarta.jakartaee-web-api` | 10.0.0 | API Jakarta EE |
| `langchain4j` | 1.7.1 | Framework IA pour Java |
| `langchain4j-google-ai-gemini` | 1.7.1 | Connexion à Gemini |
| `slf4j-jdk14` | 2.0.17 | Logging |
| `junit-jupiter` | 5.10.2 | Tests unitaires |

---

## 🔐 Configuration requise

Avant de lancer le serveur Payara, configurez la clé d’API Gemini :  
```bash
export GEMINI_KEY="votre_cle_api"
```

### Environnement
- **Java** : 21  
- **Serveur** : Payara 6.x  
- **Port** : 8080  

---

## 🧑‍💻 Auteur
**Mouhcine Khairat**  
EMSI Casablanca – IA – Groupe 2  
TP3 – Application REST avec LangChain4j & Gemini  
