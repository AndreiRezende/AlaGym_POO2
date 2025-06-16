package com.br.ala_gym_poo2.model.enums;

public enum Role {
    ROLE_FUNCIONARIO("funcionario"),
    ROLE_TREINADOR("treinador"),
    ROLE_ALUNO("aluno");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


