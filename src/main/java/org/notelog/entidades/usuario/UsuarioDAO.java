package org.notelog.entidades.usuario;

import org.notelog.config.Conexao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsuarioDAO {

    // Verifica se o usuário existe no banco de dados
    public Usuario verificaUsuario(String email, String senha) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        String sql = "SELECT U.id, F.nome, F.email, U.fkEmpresa, U.fkFuncionario " +
                "FROM Usuario AS U " +
                "JOIN Funcionario AS F ON U.fkFuncionario = F.id " +
                "WHERE F.email = ? AND U.senha = ?";
        try {
            Usuario usuario = con.queryForObject(sql, new BeanPropertyRowMapper<>(Usuario.class), email, senha);
            return usuario;
        } catch (EmptyResultDataAccessException e) {
            return null; // Retorna null se não encontrar nenhum usuário com o email e senha fornecidos
        }
    }
}
