package org.notelog.entidades.logs.cpu;

import com.github.britooo.looca.api.core.Looca;
import org.notelog.config.Conexao;
import org.notelog.entidades.cpu.Cpu;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogCpuDAO {
    public void adicionarLogCpu(LogCpu logCpu) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        Looca looca = new Looca();

        int fkCPU = con.queryForObject("SELECT id from `Cpu` ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO LogCpu (porcentagemUso, fkCPU) VALUES ('%s', '%d')"
                .formatted(looca.getProcessador().getUso(), fkCPU);
        con.update(sql);
    }
}
