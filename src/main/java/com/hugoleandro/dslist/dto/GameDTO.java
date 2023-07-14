package com.hugoleandro.dslist.dto;

// Classe que representa a entidade/modelo Game mas apenas com as informações que são necessárias para o Front-end.
// Este tipo de classes permitem otimizar a comunicação entre camadas porque filtra o que realmente é preciso ser
// mostrado. Estes objetos/informações que são transportados da camada de serviço (camada que comunica com a camada de
// dados) para os controladores, que por sua vez enviam para o Front-end, são chamados de Data Transfer Objects (DTO)

// Padrão DTO: Data Transfer Object é um padrão de projetos bastante usado em Java para o transporte de dados entre
// diferentes componentes/camadas de um sistema. A ideia consiste basicamente em agrupar um conjunto de atributos numa
// classe simples de forma a otimizar a comunicação.

import com.hugoleandro.dslist.models.Game;

public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDTO() {}

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
