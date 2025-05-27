package com.br.ala_gym_poo2.repository;

import com.br.ala_gym_poo2.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciciosRepository extends JpaRepository<Exercicio, Long> {
}
