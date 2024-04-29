package org.notelog.entidades.logs.disco;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import org.notelog.config.Conexao;
import org.notelog.entidades.disco.rigido.DiscoRigido;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class
LogDiscoDAO {
    public void adicionarLogDisco(LogDisco logDisco) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        Looca looca = new Looca();
        int fkDiscoRigido = con.queryForObject("SELECT id from DiscoRigido ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO LogDisco (fkDiscoRigido, leitura, bytesLeitura, escrita, bytesEscrita) VALUES (%d, '%s', '%s', '%s', '%s')"
                .formatted(fkDiscoRigido, logDisco.getLeituras(), logDisco.getBytesLeitura(), logDisco.getEscritas(), logDisco.getBytesEscritas());
        con.update(sql);
    }

    private boolean logDiscoExiste (LogDisco logDisco){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        //Pega o ultimo Id inserido do DiscoRigido, porem é necessário uma melhor alternativa futuramente
        int fkDiscoRigido = con.queryForObject("SELECT id from DiscoRigido ORDER BY id DESC LIMIT 1", Integer.class);

        // Dar um jeito de identificar se o registro existe ou não
        Integer quantidade = con.queryForObject(("select count(*) from DiscoRigido join LogDisco on fkDiscoRigido = DiscoRigido.id " +
                "where DiscoRigido.id = %d and leitura = '%s' and " +
                "bytesLeitura = '%s' and  escrita = '%s' and " +
                "bytesEscrita = '%s'").formatted(fkDiscoRigido, logDisco.getLeituras(), logDisco.getBytesLeitura(), logDisco.getEscritas(), logDisco.getBytesEscritas()), Integer.class);

        if (quantidade != null) {
            return quantidade > 0;
        } else {
            return false;
        }
    }

    public void adiconarNovoLogDisco() {

        Looca looca = new Looca();
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            LogDisco novoLogDiscoRigido = new LogDisco( null, disco.getLeituras().toString(), disco.getBytesDeLeitura().toString(), disco.getEscritas().toString(), disco.getBytesDeEscritas().toString());


            if (!logDiscoExiste(novoLogDiscoRigido)) {
                adicionarLogDisco(novoLogDiscoRigido);
            }
        }


    }
}
