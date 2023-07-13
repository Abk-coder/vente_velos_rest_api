package sn.ept.git.dic2.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "client")
@Entity
@DiscriminatorValue("Cl")
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "SELECT a FROM Client a"),
        @NamedQuery(name = "Client.findById", query = "SELECT a FROM Client a WHERE a.id = :id"),
        @NamedQuery(name = "Client.findByEmail", query = "SELECT a FROM Client a WHERE a.email = :email"),
        @NamedQuery(name = "Client.findByTelephone", query = "SELECT a FROM Client a WHERE a.telephone = :telephone"),
        @NamedQuery(name = "Client.findByFirstName", query = "SELECT a FROM Client a WHERE a.prenom = :prenom"),
        @NamedQuery(name = "Client.findByLastName", query = "SELECT a FROM Client a WHERE a.nom = :nom")
})
public class Client extends Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "ETAT")
    private String etat;

    @Column(name = "CODE_ZIP")
    private String codeZip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
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

    public Client() {
    }
}

