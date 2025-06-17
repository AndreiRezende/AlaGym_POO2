package com.br.ala_gym_poo2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="avaliacao_fisica")
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataAvaliacao;
    @Column
    private int percentualGordura;
    @Column
    private int massaMagra;
    @Column
    private float circunferenciaCintura;
    @Column
    private float circunferenciaQuadril;
    @Column
    private int frequenciaCardiaca;
    @Column
    private String pressaoArterial;
    @Column
    private float IMC;
    @Column(nullable=false)
    private Long usuarioId;

    public Long getUsuario() {
        return usuarioId;
    }

    public void setUsuario(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(int percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public int getMassaMagra() {
        return massaMagra;
    }

    public void setMassaMagra(int massaMagra) {
        this.massaMagra = massaMagra;
    }

    public float getCircunferenciaCintura() {
        return circunferenciaCintura;
    }

    public void setCircunferenciaCintura(float circunferenciaCintura) {
        this.circunferenciaCintura = circunferenciaCintura;
    }

    public float getCircunferenciaQuadril() {
        return circunferenciaQuadril;
    }

    public void setCircunferenciaQuadril(float circunferenciaQuadril) {
        this.circunferenciaQuadril = circunferenciaQuadril;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }


}
