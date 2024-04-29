package org.notelog.geolocalizacao;

import org.notelog.config.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class GeolocalizacaoDAO {
    public void adicionaGeolocalizacao(){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Geolocalizacao geolocalizacao = new Geolocalizacao();
        String publicIPAddress = geolocalizacao.ObterIP();
        String jsonString = geolocalizacao.ObterGeoPorIP(publicIPAddress);
        geolocalizacao.preencherDados(jsonString);

        int fkNotebook = con.queryForObject("SELECT id FROM Notebook ORDER BY id DESC LIMIT 1", Integer.class);

        String sql = "INSERT INTO Geolocalizacao (enderecoIp, pais, cidade, nomeRegiao, latitude, longitude, timezone, companiaInternet, fkNotebook) VALUES ('%s','%s', '%s', '%s', '%s','%s','%s','%s', '%d');"
                .formatted(geolocalizacao.getIp(),geolocalizacao.getCountryName(), geolocalizacao.getCityName(),
                        geolocalizacao.getRegionName(), geolocalizacao.getLatitude(), geolocalizacao.getLongitude(),
                        geolocalizacao.getTimeZone(), geolocalizacao.getAs(), fkNotebook);
        con.update(sql);

    }
}

