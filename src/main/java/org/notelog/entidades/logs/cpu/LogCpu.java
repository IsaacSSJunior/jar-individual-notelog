package org.notelog.entidades.logs.cpu;

import com.github.britooo.looca.api.core.Looca;

public class LogCpu {
    Looca looca = new Looca();

    private Integer id;
    private String porcentagemUso;
    private Integer fkCPU;

    public LogCpu() {
        this.porcentagemUso = porcentagemUso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPorcentagemUso() {
        return porcentagemUso;
    }

    public void setPorcentagemUso(String porcentagemUso) {
        this.porcentagemUso = porcentagemUso;
    }

    public Integer getFkCPU() {
        return fkCPU;
    }

    public void setFkCPU(Integer fkCPU) {
        this.fkCPU = fkCPU;
    }

    @Override
    public String toString() {
        return "org.notelog.entidades.log.cpu.LogCPU{" +
                "idLogCPU=" + id +
                ", porcentagemUso='" + porcentagemUso + '\'' +
                ", fkCPU=" + fkCPU +
                '}';
    }
}
