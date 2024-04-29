package org.notelog.geolocalizacao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geolocalizacao {
    private static final String API_KEY = "67B347539C3E108BEBCF238AD9683A3F";

    @JsonAlias({"ip"})
    private String ip;

    @JsonAlias({"country_code"})
    private String countryCode;

    @JsonAlias({"country_name"})
    private String countryName;

    @JsonAlias({"region_name"})
    private String regionName;

    @JsonAlias({"city_name"})
    private String cityName;

    @JsonAlias({"latitude"})
    private double latitude;

    @JsonAlias({"longitude"})
    private double longitude;

    @JsonAlias({"zip_code"})
    private String zipCode;

    @JsonAlias({"time_zone"})
    private String timeZone;

    @JsonAlias({"asn"})
    private String asn;

    @JsonAlias({"as"})
    private String as;

    @JsonAlias({"is_proxy"})
    private boolean isProxy;

    // Métodos Getters
    public String getIp() {
        return ip;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getAsn() {
        return asn;
    }

    public String getAs() {
        return as;
    }

    public boolean isProxy() {
        return isProxy;
    }

    // Métodos setters
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public void setProxy(boolean isProxy) {
        this.isProxy = isProxy;
    }

    public String ObterGeoPorIP(String IP) {
        try {
            URL url = new URL("https://api.ip2location.io/?key=" + API_KEY + "&ip=" + IP);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String ObterIP() {
        try {
            URL url = new URL("https://api64.ipify.org?format=text");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            String IP = response.toString();
            reader.close();
            connection.disconnect();

            return IP;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // método para formatar os dados
    public String formatarDados() {
        return "IP: " + ip +
                "\nCountry Code: " + countryCode +
                "\nCountry Name: " + countryName +
                "\nRegion Name: " + regionName +
                "\nCity Name: " + cityName +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude +
                "\nZip Code: " + zipCode +
                "\nTime Zone: " + timeZone +
                "\nASN: " + asn +
                "\nAS: " + as +
                "\nIs Proxy: " + isProxy;
    }

    public void preencherDados(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Geolocalizacao geoData = objectMapper.readValue(jsonString, Geolocalizacao.class);

            this.ip = geoData.getIp();
            this.countryCode = geoData.getCountryCode();
            this.countryName = geoData.getCountryName();
            this.regionName = geoData.getRegionName();
            this.cityName = geoData.getCityName();
            this.latitude = geoData.getLatitude();
            this.longitude = geoData.getLongitude();
            this.zipCode = geoData.getZipCode();
            this.timeZone = geoData.getTimeZone();
            this.asn = geoData.getAsn();
            this.as = geoData.getAs();
            this.isProxy = geoData.isProxy();
        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
