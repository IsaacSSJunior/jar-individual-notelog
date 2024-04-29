package org.notelog.entidades.cpu;

import com.github.britooo.looca.api.core.Looca;
import org.notelog.config.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CpuDAO {
    public void adicionarCpu(Cpu cpu) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        Looca looca = new Looca();
        int fkNotebook = con.queryForObject("SELECT id FROM Notebook ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO Cpu (nome, numeroFisico, numeroLogico, frequencia, idFisicoProcessador, fkNotebook) VALUES ('%s', '%s', '%s', '%s','%s', '%d')"
                .formatted(looca.getProcessador().getNome(), looca.getProcessador().getNumeroCpusFisicas(),
                        looca.getProcessador().getNumeroCpusLogicas(), looca.getProcessador().getFrequencia(), looca.getProcessador().getIdentificador(), fkNotebook);
        con.update(sql);
    }
}
