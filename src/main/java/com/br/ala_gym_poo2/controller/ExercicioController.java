package com.br.ala_gym_poo2.controller;


import com.br.ala_gym_poo2.model.Exercicio;
import com.br.ala_gym_poo2.repository.ExerciciosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
    private final ExerciciosRepository exerciciosRepository;

    public ExercicioController(ExerciciosRepository exerciciosRepository) {
        this.exerciciosRepository = exerciciosRepository;
    }

    @GetMapping
    public List<Exercicio> getExercicios() {
        return this.exerciciosRepository.findAll();
    }

}
