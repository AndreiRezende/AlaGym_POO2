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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
