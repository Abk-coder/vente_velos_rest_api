package sn.ept.git.dic2.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.entities.Categorie;

@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> {
    @PersistenceContext(name = "vente_velosPU")
    private EntityManager entityManager;
    public CategorieFacade() {
        super(Categorie.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };

    /**
     * finds Categorie with given name.
     *
     * @param nom
     * @return categorie
     */
    public Categorie findCategorieByName(String nom) {
        Categorie categorie = null;

        try {
            categorie = (Categorie) entityManager.createNamedQuery("Categorie.findByName").setParameter("nom", nom).getSingleResult();
            System.out.println(categorie);
        } catch (NoResultException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return categorie;
    }
}
