package sn.ept.git.dic2.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.entities.Produit;

@Stateless
public class ProduitFacade extends AbstractFacade<Produit>{
    @PersistenceContext(name = "vente_velosPU")
    private EntityManager entityManager;
    public ProduitFacade() {
        super(Produit.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };


    /**
     * finds produit with given name.
     *
     * @param name
     * @return produit
     */
    public Produit findProduitByName(String name) {
        Produit produit = null;
        try {
            produit = (Produit) entityManager.createNamedQuery("Produit.findByName").setParameter("nom", name).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return produit;
    }

    /**
     * finds produit with given id.
     *
     * @param id
     * @return produit
     */
    public Produit findProduitById(int id) {
        Produit produit = null;
        try {
            produit = (Produit) entityManager.createNamedQuery("Produit.findById").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return produit;
    }
}
