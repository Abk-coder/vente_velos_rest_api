package sn.ept.git.dic2.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    public Produit() {
    }

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    public Produit(int id, String nom, Marque marque, Categorie categorie, int anneeModel, Double prixDepart) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.categorie = categorie;
        this.anneeModel = anneeModel;
        this.prixDepart = prixDepart;
    }

    @ManyToOne
    @JoinColumn(name = "MARQUE_ID", nullable = false)
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID", nullable = false)
    private Categorie categorie;

    @Column(name = "ANNEE_MODEL", nullable = false)
    private int anneeModel;

    @Column(name = "PRIX_DEPART", nullable = false)
    private Double prixDepart;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(int anneeModel) {
        this.anneeModel = anneeModel;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }
}

