package com.br.ala_gym_poo2.controller;

import java.util.List;

public record TreinoDTO (
        String descricao, List<Long> idExercicios
){
}
