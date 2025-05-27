package com.br.ala_gym_poo2.controller;

import java.util.Date;

public record AvaliacaoFisicaDTO(
        Date dataAvaliacao, int percentualGordura, int massaMagra, float circunferenciaCintura, float circunferenciaQuadril,
        int frequenciaCardiaca, String pressaoArterial, float IMC, Long idUsuario
) {
}
