package sn.ept.git.dic2.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@DiscriminatorValue("Em")
@Table(name = "employe")
public class Employe extends Client implements Serializable{

    public Employe() {
    }

    @Column(name = "ACTIF", nullable = false)
    private boolean actif;

    @ManyToOne
    @JoinColumn(name = "MAGASIN_ID", nullable = false)
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employe manager;

    // Getters and setters

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Employe getManager() {
        return manager;
    }

    public void setManager(Employe manager) {
        this.manager = manager;
    }
}

