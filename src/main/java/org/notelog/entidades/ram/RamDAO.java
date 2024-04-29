package org.notelog.entidades.ram;

import com.github.britooo.looca.api.core.Looca;
import org.notelog.config.Conexao;
import org.notelog.entidades.cpu.Cpu;
import org.springframework.jdbc.core.JdbcTemplate;

public class  RamDAO {
    public void adicionarRam(Ram ram) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        Looca looca = new Looca();
        int fkNotebook = con.queryForObject("SELECT id FROM Notebook ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO Ram (totalMemoria, fkNotebook) VALUES ('%s', '%d')"
                .formatted(looca.getMemoria().getTotal(), fkNotebook);
        con.update(sql);
    }
}
