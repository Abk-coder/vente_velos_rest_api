package sn.ept.dic2.git.jee_platforme_vente_velos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Cl")
@Table(name = "client")
public class Client extends Personne implements Serializable{
    @OneToMany
    private List<Commande> commandes;

    public List<Commande> getClients() {
        return commandes;
    }

    public void setClients(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "ETAT")
    private String Etat;

    @Column(name = "CODE_ZIP")
    private String code_zip;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat = etat;
    }

    public String getCode_zip() {
        return code_zip;
    }

    public void setCode_zip(String code_zip) {
        this.code_zip = code_zip;
    }

    public Client() {
    }
}
