package sn.ept.git.dic2.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "categorie")
@Entity
@Table(name = "categorie")
@NamedQueries({
        @NamedQuery(name = "Categorie.findByName", query = "SELECT a FROM Categorie a WHERE a.nom = :nom")
})
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
