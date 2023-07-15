package com.hugoleandro.dslist.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Belonging")
public class Belonging {
    @EmbeddedId
    private BelongingPK id;

    private Integer position;

    public Belonging() {
        this.id = new BelongingPK();
    }

    public Belonging(Game game, GameList gameList, Integer position) {
        this.id = new BelongingPK(game, gameList);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return id.equals(belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
