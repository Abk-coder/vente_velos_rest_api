package sn.ept.dic2.git.jee_platforme_vente_velos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM")
    private String nom;

    public Categorie() {
    }

    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @OneToMany
    private List<Produit> produits;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public int getId_cat() {
        return id;
    }

    public void setId_cat(int id) {
        this.id = id;
    }

    public String getNom_cat() {
        return nom;
    }

    public void setNom_cat(String nom) {
        this.nom = nom;
    }
}
