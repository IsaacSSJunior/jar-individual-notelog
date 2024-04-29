package org.notelog.entidades.logs.ram;

import com.github.britooo.looca.api.core.Looca;
import org.notelog.config.Conexao;
import org.notelog.entidades.logs.janelas.LogJanelas;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogRamDAO {
    public void adicionarLogRam(LogRam logRam) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        Looca looca = new Looca();

        int fkRam = con.queryForObject("SELECT id from Ram ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO LogRam (fkRAM, usoMemoria, memoriaDisponivel) VALUES ('%d', '%s', '%s')"
                .formatted(fkRam, looca.getMemoria().getEmUso(), looca.getMemoria().getDisponivel());
        con.update(sql);
    }
}
