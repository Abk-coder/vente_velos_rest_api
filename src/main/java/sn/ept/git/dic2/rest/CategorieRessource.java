package sn.ept.git.dic2.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ept.git.dic2.dao.CategorieFacade;
import sn.ept.git.dic2.entities.Categorie;

import java.util.List;

@Path("/categories")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CategorieRessource {
    @EJB
    private CategorieFacade categorieFacade;

    @POST
    @Path("/addCategorie")
    public Response addCategorie(@QueryParam("nom") String nom ) {
        Categorie tmpCat = categorieFacade.findCategorieByName(nom);
        if (tmpCat != null) {
            Responses response = new Responses("La categorie avec le nom " + nom + " existe déjà.");
            return Response.status(Response.Status.CONFLICT).entity(response).build();
        }
        Categorie categorie = new Categorie();
        categorie.setNom_cat(nom);
        categorieFacade.create(categorie);
        return Response.status(Response.Status.OK).entity(categorie).build();
    }

    @PUT
    @Path("/modifier")
    public Response updateCategorie(@QueryParam("actualName") String actualName, @QueryParam("newName") String newName) {
        Categorie tmpClient = categorieFacade.findCategorieByName(actualName);
        if (tmpClient == null) {
            Responses response = new Responses("La categorie avec le nom " + actualName + " n'existe pas.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        if (newName != null && !newName.isEmpty()) tmpClient.setNom_cat(newName);

        categorieFacade.edit(tmpClient);
        return Response.status(Response.Status.OK).entity(tmpClient).build();
    }

    @GET
    @Path("/categorie")
    public Response getCategorieById(@QueryParam("id") int id) {
        Categorie categorie = categorieFacade.find(id);
        if (categorie == null) {
            Responses response = new Responses("Categorie introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(categorie).build();
    }

    @GET
    public Response getCategorieByName(@QueryParam("name") String name) {
        Categorie categorie = categorieFacade.findCategorieByName(name);
        if (categorie == null) {
            Responses response = new Responses("Categorie introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(categorie).build();
    }

    @GET
    @Path("/allCategories")
    public Response getAllCategories() {
        List<Categorie> allCategories = categorieFacade.findAll();
        if (allCategories.isEmpty()) {
            Responses response = new Responses("Aucune categorie trouvée.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(allCategories).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteCategorie(@QueryParam("id") int id) {
        Categorie tmpCategorie = categorieFacade.find(id);
        if (tmpCategorie == null) {
            Responses response = new Responses("Categorie introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }

        categorieFacade.remove(tmpCategorie);
        return Response.status(Response.Status.OK).entity(tmpCategorie).build();
    }

}
