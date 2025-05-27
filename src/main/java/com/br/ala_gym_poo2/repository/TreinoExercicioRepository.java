package com.br.ala_gym_poo2.repository;

import com.br.ala_gym_poo2.model.TreinoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, Long> {
    TreinoExercicio findByTreinoId(Long id);
}
