package org.notelog.entidades.logs.disco;

import com.github.britooo.looca.api.core.Looca;

public class LogDisco {
    Looca looca = new Looca();
    private Integer id;
    private Integer fkDiscoRigido;
    private String leituras;
    private String bytesLeitura;
    private String escritas;
    private String bytesEscritas;

    public LogDisco(Integer fkDiscoRigido, String leituras, String bytesLeitura, String escritas, String bytesEscritas) {
        this.fkDiscoRigido = fkDiscoRigido;
        this.leituras = leituras;
        this.bytesLeitura = bytesLeitura;
        this.escritas = escritas;
        this.bytesEscritas = bytesEscritas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkDiscoRigido() {
        return fkDiscoRigido;
    }

    public void setFkDiscoRigido(Integer fkDiscoRigido) {
        this.fkDiscoRigido = fkDiscoRigido;
    }

    public String getLeituras() {
        return leituras;
    }

    public void setLeituras(String leituras) {
        this.leituras = leituras;
    }

    public String getBytesLeitura() {
        return bytesLeitura;
    }

    public void setBytesLeitura(String bytesLeitura) {
        this.bytesLeitura = bytesLeitura;
    }

    public String getEscritas() {
        return escritas;
    }

    public void setEscritas(String escritas) {
        this.escritas = escritas;
    }

    public String getBytesEscritas() {
        return bytesEscritas;
    }

    public void setBytesEscritas(String bytesEscritas) {
        this.bytesEscritas = bytesEscritas;
    }

    @Override
    public String toString() {
        return "org.notelog.entidades.logs.disco.LogDisco{" +
                "idLogDisco=" + id +
                ", fkDiscoRigido=" + fkDiscoRigido +
                ", leituras='" + leituras + '\'' +
                ", bytesLeitura='" + bytesLeitura + '\'' +
                ", escritas='" + escritas + '\'' +
                ", bytesEscritas='" + bytesEscritas + '\'' +
                '}';
    }
}
