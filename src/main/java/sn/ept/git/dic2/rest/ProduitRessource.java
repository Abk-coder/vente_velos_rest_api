package sn.ept.git.dic2.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ept.git.dic2.dao.ProduitFacade;
import sn.ept.git.dic2.entities.Produit;

import java.util.List;

@Path("/produits")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProduitRessource {
    @EJB
    private ProduitFacade produitFacade;

    @POST
    @Path("/newProduit")
    public Response addProduit(Produit produit)
    {
        produitFacade.create(produit);
        return Response.status(Response.Status.OK).entity(produit).build();
    }

    @PUT
    @Path("/update")
    public Response updateClient(@QueryParam("anneeModel") int anneemodel,
                                 @QueryParam("nom") String nom,
                                 @QueryParam("prixDepart") double prixDepart,
                                 @QueryParam("id") int id)
    {
        Produit tmpProduit = produitFacade.findProduitById(id);
        if (tmpProduit == null) {
            Responses response = new Responses("Le produit dont l'id est " + id + " n'existe pas.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        if (nom != null && !nom.isEmpty()) tmpProduit.setNom(nom);
        if (anneemodel != 0) tmpProduit.setAnneeModel(anneemodel);
        if (prixDepart != 0.0 ) tmpProduit.setPrixDepart(prixDepart);
        produitFacade.edit(tmpProduit);
        return Response.status(Response.Status.OK).entity(tmpProduit).build();
    }

    @GET
    @Path("/produit")
    public Response getProduitById(@QueryParam("id") int id) {
        Produit produit = produitFacade.findProduitById(id);
        if (produit == null) {
            Responses response = new Responses("Produit introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(produit).build();
    }

    @GET
    public Response getProduitByName(@QueryParam("name") String name) {
        Produit p = produitFacade.findProduitByName(name);
        if (p == null) {
            Responses response = new Responses("Produit introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(p).build();
    }

    @GET
    @Path("/allProduits")
    public Response getAllProduits() {
        List<Produit> allProduits = produitFacade.findAll();
        if (allProduits.isEmpty()) {
            Responses response = new Responses("Aucun produit trouvé.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(allProduits).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteClient(@QueryParam("id") int id) {
        Produit p = produitFacade.findProduitById(id);
        if (p == null) {
            Responses response = new Responses("Ce produit n'esxite pas.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        produitFacade.remove(p);
        return Response.status(Response.Status.OK).entity(p).build();
    }

}
