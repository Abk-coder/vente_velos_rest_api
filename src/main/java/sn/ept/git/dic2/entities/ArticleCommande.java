package sn.ept.git.dic2.entities;

import jakarta.persistence.*;

import java.io.Serializable;



@Entity
@NamedQueries({
        @NamedQuery(name = "ArticleCommande.findById", query = "SELECT a FROM ArticleCommande a WHERE a.id.numeroCommande = :numCommande AND a.id.ligne= :ligne")
})
public class ArticleCommande implements Serializable{

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ArticleCommandeId id;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandeId id, int quantite, double prixDepart, double remise) {
        this.id = id;
        this.quantite = quantite;
        this.prixDepart = prixDepart;
        this.remise = remise;
    }

    private int quantite;

    private double prixDepart;

    private double remise;

    private int produit_id;

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
// Getters and setters

    public ArticleCommandeId getId() {
        return id;
    }

    public void setId(ArticleCommandeId id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }
}
