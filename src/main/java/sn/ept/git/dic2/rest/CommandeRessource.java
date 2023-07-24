package sn.ept.git.dic2.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ept.git.dic2.dao.CommandeFacade;
import sn.ept.git.dic2.entities.Commande;

import java.util.Date;
import java.util.List;

@Path("/commandes")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CommandeRessource {
    @EJB
    private CommandeFacade commandeFacade;

    @POST
    @Path("/addCommande")
    public Response addCommande(Commande commande) {
        commandeFacade.create(commande);
        return Response.status(Response.Status.OK).entity(commande).build();
    }

    @PUT
    @Path("/update")
    public Response updateCommande(@QueryParam("date_commande") Date date_commande,
                                  @QueryParam("date_livraison_voulue") Date date_livraison_voulue,
                                  @QueryParam("date_livraison") Date date_livraison,
                                  @QueryParam("numero") int numero) {
        Commande tmpCommande = commandeFacade.find(numero);
        if (tmpCommande == null) {
            Responses response = new Responses("La commande  n'existe pas.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        if (date_commande != null) tmpCommande.setDateCommande(date_commande);
        if (date_livraison_voulue != null) tmpCommande.setDateLivraisonVoulue(date_livraison_voulue);
        if(date_livraison != null) tmpCommande.setDateLivraison(date_livraison);

        commandeFacade.edit(tmpCommande);
        return Response.status(Response.Status.OK).entity(tmpCommande).build();
    }

    @GET
    @Path("/commande")
    public Response getCommandeNumber(@QueryParam("numero") int numero) {
        Commande commande = commandeFacade.find(numero);
        if (commande == null) {
            Responses response = new Responses("Commande introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(commande).build();
    }


    @GET
    @Path("/allCommandes")
    public Response getAllCommandes() {
        List<Commande> allCommandes = commandeFacade.findAll();
        if (allCommandes.isEmpty()) {
            Responses response = new Responses("Aucune commande trouvée.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(allCommandes).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteCommande(@QueryParam("numero") int numero) {
        Commande tmpCommande = commandeFacade.find(numero);
        if (tmpCommande == null) {
            Responses response = new Responses("Commande introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }

        commandeFacade.remove(tmpCommande);
        return Response.status(Response.Status.OK).entity(tmpCommande).build();
    }
}
