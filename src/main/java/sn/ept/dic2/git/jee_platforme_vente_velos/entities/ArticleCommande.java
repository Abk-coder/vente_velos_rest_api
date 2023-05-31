package sn.ept.dic2.git.jee_platforme_vente_velos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;



@Entity
@Table(name = "article_commande")
public class ArticleCommande implements Serializable{

    @EmbeddedId
    private ArticleCommandeId id;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandeId id, int quantite, double prixDepart, double remise) {
        this.id = id;
        this.quantite = quantite;
        this.prixDepart = prixDepart;
        this.remise = remise;
    }

    @Column(name = "QUANTITE", nullable = false)
    private int quantite;

    @Column(name = "PRIX_DEPART", nullable = false)
    private double prixDepart;

    @Column(name = "REMISE", nullable = false)
    private double remise;

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
