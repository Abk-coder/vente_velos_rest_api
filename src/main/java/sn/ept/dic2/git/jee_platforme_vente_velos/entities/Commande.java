package sn.ept.dic2.git.jee_platforme_vente_velos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{

    @Id
    @Column(name = "NUMERO")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Column(name = "STATUT", nullable = false)
    private int statut;

    @Column(name = "DATE_COMMANDE", nullable = false)
    private Date dateCommande;

    @Column(name = "DATE_LIVRAISON_VOULUE", nullable = false)
    private Date dateLivraisonVoulue;

    @Column(name = "DATE_LIVRAISON")
    private Date dateLivraison;

    @ManyToOne
    @JoinColumn(name = "MAGASIN_ID", nullable = false)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "VENDEUR_ID", nullable = false)
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