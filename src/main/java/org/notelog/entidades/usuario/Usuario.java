package org.notelog.entidades.usuario;

public class Usuario {

private Integer id;
private String nome;
private String senha;
private Integer fkEmpresa;
private Integer fkFuncionario;

    public Usuario(Integer id, String nome, String senha, Integer fkEmpresa, Integer fkFuncionario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.fkEmpresa = fkEmpresa;
        this.fkFuncionario = fkFuncionario;
    }

    public Usuario(){

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(Integer fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", fkEmpresa=" + fkEmpresa +
                ", fkFuncionario=" + fkFuncionario +
                '}';
    }
}
