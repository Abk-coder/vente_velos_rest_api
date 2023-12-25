package sn.ept.git.dic2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    @EmbeddedId
    private StockId id;

    @Column(name = "QUANTITE", nullable = false)
    private int quantite;

    public Stock() {
    }

    public Stock(StockId id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

    public StockId getId() {
        return id;
    }

    public void setId(StockId id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
