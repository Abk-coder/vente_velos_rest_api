package sn.ept.dic2.git.jee_platforme_vente_velos.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "magasin")
public class Magasin implements Serializable {

    public Magasin() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @OneToMany
    private List<Employe> employes;

    @OneToMany
    private List<Commande> commandes;

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Magasin(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "ETAT")
    private String etat;

    @Column(name = "CODE_ZIP")
    private String codeZip;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCodeZip() {
        return codeZip;
    }

    public void setCodeZip(String codeZip) {
        this.codeZip = codeZip;
    }
}

