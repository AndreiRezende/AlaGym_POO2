package com.br.ala_gym_poo2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="treino")
public class Treino {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return descricao;
    }

    public void setDescription(String description) {
        this.descricao = description;
    }
}
