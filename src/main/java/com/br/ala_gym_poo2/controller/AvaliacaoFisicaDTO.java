package com.br.ala_gym_poo2.controller;

import java.time.LocalDate;

public record AvaliacaoFisicaDTO(
        LocalDate dataAvaliacao, int percentualGordura, int massaMagra, float circunferenciaCintura, float circunferenciaQuadril,
        int frequenciaCardiaca, String pressaoArterial, float IMC, Long idUsuario
) {
}
