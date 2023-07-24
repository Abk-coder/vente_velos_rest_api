package sn.ept.git.dic2.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{

    @Id
    private int numero;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private int statut;

    @Column(name = "date_commande", nullable = false)
    private Date dateCommande;

    @Column(name = "date_livraison_voulue", nullable = false)
    private Date dateLivraisonVoulue;

    @Column(name = "date_livraison")
    private Date dateLivraison;

    @ManyToOne
    @JoinColumn(name = "magasin_id", nullable = false)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "vendeur_id", nullable = false)
    private Employe vendeur;

    // Getters and setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Commande() {
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public Commande(int numero, Date dateCommande, Date dateLivraisonVoulue) {
        this.numero = numero;
        this.dateCommande = dateCommande;
        this.dateLivraisonVoulue = dateLivraisonVoulue;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraisonVoulue() {
        return dateLivraisonVoulue;
    }

    public void setDateLivraisonVoulue(Date dateLivraisonVoulue) {
        this.dateLivraisonVoulue = dateLivraisonVoulue;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Employe getVendeur() {
        return vendeur;
    }

    public void setVendeur(Employe vendeur) {
        this.vendeur = vendeur;
    }
}