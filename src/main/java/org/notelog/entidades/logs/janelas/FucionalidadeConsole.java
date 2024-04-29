package org.notelog.entidades.logs.janelas;
import java.io.*;

public class FucionalidadeConsole {

    // Encerrar processo por PID
    public void encerraProcesso(Integer pid) {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // Encerra o processo no Windows usando o comando taskkill
                Runtime.getRuntime().exec("taskkill /F /PID " + pid).waitFor();
            } else {
                // Encerra o processo no Linux usando o comando kill
                Runtime.getRuntime().exec("sudo kill -9 " + pid).waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }





}
