package com.br.ala_gym_poo2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "treinoExercicio")
public class TreinoExercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long treinoId;
    @Column(nullable = false)
    private List<Long> exercicioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(Long treinoId) {
        this.treinoId = treinoId;
    }

    public List<Long> getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(List<Long> exercicioId) {
        this.exercicioId = exercicioId;
    }
}
