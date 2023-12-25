package sn.ept.git.dic2.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "marque")
public class Marque implements Serializable {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NOM")
    private String name;

    @OneToMany
    private List<Produit> produit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marque() {
    }

    public Marque(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }
}
