package com.hugoleandro.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

// Criação da entidade relacional Game através de uma abordagem Code-First
@Entity
@Table(name = "Game")
public class Game {
    // Tipos primitivos de dados (int) vs Classes derivadas dos tipos primitivos de dados (Integer):
        // Tipos primitivos de dados não aceitam valores NULL
        // Classes derivadas dis tipos primitivos já permitem valores NULL
        // Utilizar tipo primitivos de dados para campos que são de preenchimento obrigatório, porque o objetivo não é
        // armazenar valores NULL e porque os tipos primitivos sãos mais eficientes
        // Utilizar as classes derivadas dos tipos primitivos para campos que não sejam de preenchimento obrigatório,
        // já que são esperados valores NULL
    @Id // Anotação para definir uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para definir Auto Incremento
    private Long id;

    private String title;

    @Column(name = "gameYear") // Anotação para definir o nome do campo na DB
    private Integer year;

    private String genre;

    private String platforms;

    private Double score;

    private String imgUrl;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;


    public Game() {}

    public Game(long id, String title, int year, String genre, String platforms, double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public double getScore() {
        return score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
