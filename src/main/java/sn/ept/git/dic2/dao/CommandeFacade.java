package sn.ept.git.dic2.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.entities.Commande;

@Stateless
public class CommandeFacade extends AbstractFacade<Commande>{
    @PersistenceContext(name = "vente_velosPU")
    private EntityManager entityManager;
    public CommandeFacade() {
        super(Commande.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
//
//    /**
//     * finds client with given email.
//     *
//     * @param numCommande, ligne
//     * @return commande
//     */
//    public ArticleCommande findCommandeById(int numCommande, int ligne) {
//        ArticleCommande commande = null;
//
//        try {
//            commande = (ArticleCommande) entityManager
//                    .createNamedQuery("ArticleCommande.findById")
//                    .setParameter("numCommande", numCommande)
//                    .setParameter("ligne", ligne)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
//        return commande;
//    }

}
