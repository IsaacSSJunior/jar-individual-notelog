package org.notelog.entidades.cpu;

import com.github.britooo.looca.api.core.Looca;

public class Cpu {
    Looca looca = new Looca();

    private Integer id;
    private String nome;
    private String numeroFisico;
    private String numerologico;
    private String frequencia;
    private String idFisicoProcessador;
    private String fkNotebook;

    public Cpu() {
        this.nome = nome;
        this.numeroFisico = numeroFisico;
        this.numerologico = numerologico;
        this.frequencia = frequencia;
        this.idFisicoProcessador = idFisicoProcessador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroFisico() {
        return numeroFisico;
    }

    public void setNumeroFisico(String numeroFisico) {
        this.numeroFisico = numeroFisico;
    }

    public String getNumerologico() {
        return numerologico;
    }

    public void setNumerologico(String numerologico) {
        this.numerologico = numerologico;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getIdFisicoProcessador() {
        return idFisicoProcessador;
    }

    public void setIdFisicoProcessador(String idFisicoProcessador) {
        this.idFisicoProcessador = idFisicoProcessador;
    }

    public Looca getLooca() {
        return looca;
    }

    public void setLooca(Looca looca) {
        this.looca = looca;
    }

    public String getFkNotebook() {
        return fkNotebook;
    }

    public void setFkNotebook(String fkNotebook) {
        this.fkNotebook = fkNotebook;
    }

    @Override
    public String toString() {
        return "org.notelog.entidades.cpu.CPU{" +
                "idCPU=" + id +
                ", nome='" + nome + '\'' +
                ", numeroFisico='" + numeroFisico + '\'' +
                ", numerologico='" + numerologico + '\'' +
                ", frequencia='" + frequencia + '\'' +
                ", idFisicoProcessador='" + idFisicoProcessador + '\'' +
                '}';
    }
}
