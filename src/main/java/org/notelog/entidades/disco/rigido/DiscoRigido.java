package org.notelog.entidades.disco.rigido;

public class DiscoRigido {

    private Integer id;
    private String modelo;
    private String serial;
    private String tamanho;
    private Integer fkNotebook;

    public DiscoRigido(Integer idDisco, String modelo, String serial, String tamanho) {
        this.id = idDisco;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.serial = serial;
    }

    public DiscoRigido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getFkNotebook() {
        return fkNotebook;
    }

    public void setFkNotebook(Integer fkNotebook) {
        this.fkNotebook = fkNotebook;
    }

    @Override
    public String toString() {
        return "DiscosRigidos{" +
                "idDisco=" + id +
                ", modelo='" + modelo + '\'' +
                ", serial='" + serial + '\'' +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}
