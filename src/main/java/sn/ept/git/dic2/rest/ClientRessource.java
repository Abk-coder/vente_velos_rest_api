package sn.ept.git.dic2.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sn.ept.git.dic2.dao.ClientFacade;
import sn.ept.git.dic2.entities.Client;

import java.util.List;

@Path("/clients")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ClientRessource {
    @EJB
    private ClientFacade clientFacade;

    @POST
    @Path("/newClient")
    public Response addClient(Client c) {
        Client tmpClient = clientFacade.findClientByEmail(c.getEmail());
        if (tmpClient != null) {
            Responses response = new Responses("Le client avec l'adresse mail " + c.getEmail() + " existe déjà.");
            return Response.status(Response.Status.CONFLICT).entity(response).build();
        }
        clientFacade.create(c);
        return Response.status(Response.Status.OK).entity(c).build();
    }

//    @PUT
//    @Path("/update/id")
//    public Response updateClient(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("adresse") String adresse, @QueryParam("email") String email) {
//        Client tmpClient = clientFacade.findClientByEmail(email);
//        if (tmpClient == null) {
//            Responses response = new Responses("Le client avec l'adresse mail " + email + " n'existe pas.");
//            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
//        }
//        if (nom != null && !nom.isEmpty()) tmpClient.setNom(nom);
//        if (prenom != null && !prenom.isEmpty()) tmpClient.setPrenom(prenom);
//        if (adresse != null && !adresse.isEmpty()) tmpClient.setAdresse(adresse);
//        clientFacade.edit(tmpClient);
//        return Response.status(Response.Status.OK).entity(tmpClient).build();
//    }

    @GET
    @Path("/client")
    public Response getClientById(@QueryParam("id") int id) {
        Client client = clientFacade.findClientById(id);
        if (client == null) {
            Responses response = new Responses("Client introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(client).build();
    }

    @GET
    public Response getClientByEmail(@QueryParam("email") String email) {
        Client client = clientFacade.findClientByEmail(email);
        if (client == null) {
            Responses response = new Responses("Client introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(client).build();
    }

    @GET
    @Path("/alllClients")
    public Response getAllClients() {
        List<Client> allClients = clientFacade.findAll();
        if (allClients.isEmpty()) {
            Responses response = new Responses("Aucun client trouvé.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(allClients).build();
    }

//    @DELETE
//    @Path("/delete/id")
//    public Response deleteClient(@QueryParam("id") int id) {
//        Client client = clientFacade.findClientById(id);
//        if (client == null) {
//            Responses response = new Responses("Client introuvable.");
//            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
//        }
//        clientFacade.remove(client);
//        return Response.status(Response.Status.OK).entity(client).build();
//    }
//
//    @GET
//    @Path("/test")
//    public String getTest() {
//        return "Hello World!";
//    }
}
