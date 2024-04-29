package org.notelog.entidades.tempo.atividade;

import com.github.britooo.looca.api.core.Looca;

import java.sql.Date;
import java.sql.Time;
import java.time.DateTimeException;

public class TempoDeAtividade {
    Looca looca = new Looca();
    private Integer id;
    private Integer fkNotebook;
//    Verificar se tipo TIME e DateTimeException funciona na inserção do bd (se não usar String e alterar no bd para VARCHAR)
    private String tempoDeAtividade;
    private DateTimeException tempoInicializado;

    public TempoDeAtividade() {
        this.tempoDeAtividade = tempoDeAtividade;
        this.tempoInicializado = tempoInicializado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkNotebook() {
        return fkNotebook;
    }

    public void setFkNotebook(Integer fkNotebook) {
        this.fkNotebook = fkNotebook;
    }

    public String getTempoDeAtividade() {
        return tempoDeAtividade;
    }

    public void setTempoDeAtividade(String tempoDeAtividade) {
        this.tempoDeAtividade = tempoDeAtividade;
    }

    public DateTimeException getTempoInicializado() {
        return tempoInicializado;
    }

    public void setTempoInicializado(DateTimeException tempoInicializado) {
        this.tempoInicializado = tempoInicializado;
    }

    @Override
    public String toString() {
        return "org.notelog.entidades.tempo.atividade.TempoDeAtividade{" +
                "idTempoDeAtividade=" + id +
                ", fkNotebook=" + fkNotebook +
                ", tempoDeAtividade=" + tempoDeAtividade +
                ", tempoInicializado=" + tempoInicializado +
                '}';
    }
}
