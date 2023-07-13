package sn.ept.git.dic2.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.entities.Client;

@Stateless
public class ClientFacade extends AbstractFacade<Client>{
    @PersistenceContext(name = "vente_velosPU")
    private EntityManager entityManager;
    public ClientFacade() {
        super(Client.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };


    /**
     * finds client with given email.
     *
     * @param email
     * @return client
     */
    public Client findClientByEmail(String email) {
        Client client = null;

        try {
            client = (Client) entityManager.createNamedQuery("Client.findByEmail").setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return client;
    }

    /**
     * finds client with given email.
     *
     * @param id
     * @return client
     */
    public Client findClientById(int id) {
        Client client = null;

        try {
            client = (Client) entityManager.createNamedQuery("Client.findById").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return client;
    }
}
