package org.notelog.entidades.notebook;

import com.github.britooo.looca.api.core.Looca;

public class Notebook {

    private Integer id;
    private String sistemaOperacional;
    private String fabricante;
    private Integer arquitetura;
    private Integer fkFuncionario;

    public Notebook() {
        this.sistemaOperacional = sistemaOperacional;
        this.fabricante = fabricante;
        this.arquitetura = arquitetura;
        this.fkFuncionario = fkFuncionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(Integer arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Integer getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(Integer fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    @Override
    public String toString() {
        return """
                Notebook %d
                Sistema operacional: %s
                Fabricante: %s
                Arquiteta: %s
                fkFuncionario: %d
                """.formatted(id, sistemaOperacional, fabricante, arquitetura, fkFuncionario);
    }
}
