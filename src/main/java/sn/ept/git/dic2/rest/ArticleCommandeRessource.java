package sn.ept.git.dic2.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ept.git.dic2.dao.ArticleCommandeFacade;
import sn.ept.git.dic2.entities.ArticleCommande;

import java.util.List;

@Path("/articles")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ArticleCommandeRessource {
    @EJB
    private ArticleCommandeFacade articleFacade;

    @POST
    @Path("/addArticle")
    public Response addArticle(ArticleCommande article) {
        articleFacade.create(article);
        return Response.status(Response.Status.OK).entity(article).build();
    }

    @PUT
    @Path("/update")
    public Response updateArticle(@QueryParam("prix") double prix,
                                   @QueryParam("numArticle") int numArticle,
                                   @QueryParam("ligne") int ligne,
                                   @QueryParam("produit_id") int produit_id,
                                   @QueryParam("remise") double remise) {
        ArticleCommande tmpArticle = articleFacade.findCommandeById(numArticle, ligne);
        if (tmpArticle == null) {
            Responses response = new Responses("La Article  n'existe pas.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        if (prix != 0.0) tmpArticle.setPrixDepart(prix);
        if (produit_id != 0) tmpArticle.setProduit_id(produit_id);
        tmpArticle.setRemise(remise);

        articleFacade.edit(tmpArticle);
        return Response.status(Response.Status.OK).entity(tmpArticle).build();
    }

    @GET
    @Path("/article")
    public Response getArticleByCommandeNumber(@QueryParam("numCommande") int numCommande,
                                                @QueryParam("ligne") int ligne) {
        ArticleCommande article = articleFacade.findCommandeById(numCommande, ligne);
        if (article == null) {
            Responses response = new Responses("Article introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(article).build();
    }


    @GET
    @Path("/allArticles")
    public Response getAllArticles() {
        List<ArticleCommande> allArticles = articleFacade.findAll();
        if (allArticles.isEmpty()) {
            Responses response = new Responses("Aucun article trouvé.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(allArticles).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteCommande(@QueryParam("numCommande") int numCommande,
                                   @QueryParam("ligne") int ligne) {
        ArticleCommande tmpArticle = articleFacade.findCommandeById(numCommande, ligne);
        if (tmpArticle == null) {
            Responses response = new Responses("Article introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }

        articleFacade.remove(tmpArticle);
        return Response.status(Response.Status.OK).entity(tmpArticle).build();
    }
}
