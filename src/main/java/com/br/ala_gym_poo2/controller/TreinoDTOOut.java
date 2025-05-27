package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.model.Exercicio;
import com.br.ala_gym_poo2.model.Treino;

import java.util.List;

public record TreinoDTOOut(Treino treino, List<Exercicio> exercicios) {
}
