package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.model.AvaliacaoFisica;
import com.br.ala_gym_poo2.model.Usuario;
import com.br.ala_gym_poo2.repository.AvaliacaoFisicaRepository;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final UsuarioRepository usuarioRepository;

    public AvaliacaoFisicaController(AvaliacaoFisicaRepository repository, UsuarioRepository usuarioRepository) {
        this.avaliacaoFisicaRepository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<AvaliacaoFisica> getAvaliacaoFisica() {
        return this.avaliacaoFisicaRepository.findAll();
    }

    @PostMapping
    public AvaliacaoFisica createAvaliacaoFisica(@RequestBody AvaliacaoFisicaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado com o ID: " + dto.idUsuario()));

        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setDataAvaliacao(dto.dataAvaliacao());
        avaliacao.setPercentualGordura(dto.percentualGordura());
        avaliacao.setMassaMagra(dto.massaMagra());
        avaliacao.setCircunferenciaCintura(dto.circunferenciaCintura());
        avaliacao.setCircunferenciaQuadril(dto.circunferenciaQuadril());
        avaliacao.setFrequenciaCardiaca(dto.frequenciaCardiaca());
        avaliacao.setPressaoArterial(dto.pressaoArterial());
        avaliacao.setIMC(dto.IMC());
        avaliacao.setUsuario(usuario.getId());

        return this.avaliacaoFisicaRepository.save(avaliacao);
    }

    @DeleteMapping("/{id}")
    public void deleteAvaliacaoFisica(@PathVariable Long id) {
        this.avaliacaoFisicaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica updateAvaliacaoFisica(@PathVariable Long id, @RequestBody AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica avaliacao = this.avaliacaoFisicaRepository.findById(id).get();
        avaliacao.setDataAvaliacao(dto.dataAvaliacao());
        avaliacao.setPercentualGordura(dto.percentualGordura());
        avaliacao.setMassaMagra(dto.massaMagra());
        avaliacao.setCircunferenciaCintura(dto.circunferenciaCintura());
        avaliacao.setCircunferenciaQuadril(dto.circunferenciaQuadril());
        avaliacao.setFrequenciaCardiaca(dto.frequenciaCardiaca());
        avaliacao.setPressaoArterial(dto.pressaoArterial());
        avaliacao.setIMC(dto.IMC());

        Usuario usuario = new Usuario();
        usuario.setId(dto.idUsuario());
        avaliacao.setUsuario(usuario.getId());

        return this.avaliacaoFisicaRepository.save(avaliacao);
    }

}
