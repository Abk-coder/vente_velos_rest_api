package sn.ept.git.dic2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleCommandeId implements Serializable {

    @Column(name = "NUMERO_COMMANDE", nullable = false)
    private int numeroCommande;

    @Column(name = "LIGNE", nullable = false)
    private int ligne;

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleCommandeId)) return false;
        ArticleCommandeId that = (ArticleCommandeId) o;
        return getNumeroCommande() == that.getNumeroCommande() && getLigne() == that.getLigne();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroCommande(), getLigne());
    }

    public ArticleCommandeId() {
    }

    public ArticleCommandeId(int numeroCommande, int ligne) {
        this.numeroCommande = numeroCommande;
        this.ligne = ligne;
    }
}