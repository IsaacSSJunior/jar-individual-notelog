package org.notelog.entidades.logs.ram;

import com.github.britooo.looca.api.core.Looca;

public class LogRam {
    Looca looca = new Looca();
    private Integer id;
    private Integer fkRAM;
    private String usoMemoria;
    private String memoriaDisponivel;

    public LogRam() {
        this.fkRAM = fkRAM;
        this.usoMemoria = usoMemoria;
        this.memoriaDisponivel = memoriaDisponivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkRAM() {
        return fkRAM;
    }

    public void setFkRAM(Integer fkRAM) {
        this.fkRAM = fkRAM;
    }

    public String getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(String usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public String getMemoriaDisponivel() {
        return memoriaDisponivel;
    }

    public void setMemoriaDisponivel(String memoriaDisponivel) {
        this.memoriaDisponivel = memoriaDisponivel;
    }

    @Override
    public String toString() {
        return "org.notelog.entidades.logs.ram.LogRAM{" +
                "idLogRAM=" + id +
                ", fkRAM=" + fkRAM +
                ", usoMemoria='" + usoMemoria + '\'' +
                ", memoriaDisponivel='" + memoriaDisponivel + '\'' +
                '}';
    }
}
