package sn.ept.dic2.git.jee_platforme_vente_velos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockId implements Serializable {
    @Column(name = "MAGASIN_ID", nullable = false)
    private int magasinId;

    @Column(name = "PRODUIT_ID", nullable = false)
    private int produitId;

    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public StockId() {
    }

    public StockId(int magasinId, int produitId) {
        this.magasinId = magasinId;
        this.produitId = produitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockId)) return false;
        StockId stockId = (StockId) o;
        return magasinId == stockId.magasinId && produitId == stockId.produitId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(magasinId, produitId);
    }
}
