package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.model.AvaliacaoFisica;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDTO(
        String nome, String email, String senha, String telefone, String endereco, String permissao, int idade,
        char sexo, int cref, float peso, float altura, boolean statusPagamento, List<AvaliacaoFisica> avaliacaoFisica
        )
{

}
