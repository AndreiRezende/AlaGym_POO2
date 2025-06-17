package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.model.Exercicio;
import com.br.ala_gym_poo2.model.Treino;
import com.br.ala_gym_poo2.model.TreinoExercicio;
import com.br.ala_gym_poo2.repository.ExerciciosRepository;
import com.br.ala_gym_poo2.repository.TreinoExercicioRepository;
import com.br.ala_gym_poo2.repository.TreinoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    private final TreinoRepository treinoRepository;
    private final ExerciciosRepository exerciciosRepository;
    private final TreinoExercicioRepository treinoExercicioRepository;

    public TreinoController(
            TreinoRepository treinoRepository, ExerciciosRepository exerciciosRepository, TreinoExercicioRepository treinoExercicioRepository) {
        this.treinoRepository = treinoRepository;
        this.exerciciosRepository = exerciciosRepository;
        this.treinoExercicioRepository = treinoExercicioRepository;
    }

    @GetMapping
    public List<TreinoDTOOut> getTreinos() {
        List<TreinoDTOOut> dtos = new ArrayList<>();
        this.treinoRepository.findAll().forEach(treino -> {
            List<Exercicio> exercicios = new ArrayList<>();
            TreinoExercicio te = treinoExercicioRepository.findByTreinoId(treino.getId());
            te.getExercicioId().forEach(id -> {
                exercicios.add(this.exerciciosRepository.findById(id).get());
            });

            dtos.add(new TreinoDTOOut(treino, exercicios));


        });
        return dtos;
    }

    @GetMapping("/{id}")
    public Treino getTreinoById(@PathVariable Long id) {
        return this.treinoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TreinoDTOOut createTreino(@RequestBody TreinoDTO dto) {
        List<Exercicio> exercicios = new ArrayList<>();

        dto.idExercicios().forEach(id ->{
            Exercicio exercicio = this.exerciciosRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Exercicio id " + id + " not found!"));
            exercicios.add(exercicio);
        });

        Treino treino = new Treino();
        treino.setDescricao(dto.descricao());

        treinoRepository.save(treino);
        TreinoExercicio treinoExercicio = new TreinoExercicio();
        treinoExercicio.setTreinoId(treino.getId());
        treinoExercicio.setExercicioId(dto.idExercicios());

        treinoExercicioRepository.save(treinoExercicio);

        return new TreinoDTOOut(treino, exercicios);

    }

    @PutMapping("/{id}")
    public TreinoDTOOut updateTreino(@PathVariable Long id, @RequestBody TreinoDTO dto) {
        Treino treino = treinoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Treino " + id + " not found!"));
        TreinoExercicio treinoExercicio = treinoExercicioRepository.findByTreinoId(treino.getId());
        List<Exercicio> exercicios = new ArrayList<>();
        dto.idExercicios().forEach(exerciciosId ->{
            Exercicio exercicio = this.exerciciosRepository.findById(exerciciosId)
                    .orElseThrow(() -> new RuntimeException("Exercicio id " + exerciciosId + " not found!"));
            exercicios.add(exercicio);
        });
        treinoExercicio.setExercicioId(dto.idExercicios());
        treino.setDescricao(dto.descricao());
        treinoRepository.save(treino);
        treinoExercicioRepository.save(treinoExercicio);

        return new TreinoDTOOut(treino, exercicios);
    }

    @DeleteMapping("/{id}")
    public void deleteTreino(@PathVariable Long id){
        this.treinoRepository.deleteById(id);
        Long idTreinoExercicio = this.treinoExercicioRepository.findByTreinoId(id).getId();
        this.treinoExercicioRepository.deleteById(idTreinoExercicio);
    }
}
