package com.br.ala_gym_poo2.model;

import com.br.ala_gym_poo2.model.enums.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //Atributos Gerais
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false, unique = true)
    private String email;
    @Column(nullable=false)
    private String senha;
    @Column(nullable=false)
    private String telefone;
    @Column(nullable=false)
    private String endereco;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role permissao;
    @Column(nullable = false)
    private int idade;
    @Column(nullable=false)
    private char sexo;
    //Atributos Instrutor
    @Column
    private int cref;
    //Atributos Aluno
    @Column
    private float peso;
    @Column
    private float altura;
    @Column
    private boolean statusPagamento;
    @Column
    private List<Long> idsTreino;

    public List<Long> getIdsTreino() {
        return idsTreino;
    }

    public void setIdsTreino(List<Long> idsTreino) {
        this.idsTreino = idsTreino;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCref() {
        return cref;
    }

    public void setCref(int cref) {
        this.cref = cref;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Role getPermissao() {
        return permissao;
    }

    public void setPermissao(Role permissao) {
        this.permissao = permissao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
