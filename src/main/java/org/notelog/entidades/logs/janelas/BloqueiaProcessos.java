package org.notelog.entidades.logs.janelas;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

import java.io.*;

public class BloqueiaProcessos {

    // Encerrar processo por PID

    public String obterNomeDoProcessoPorPIDLixux(int pid) {
        String nomeDoProcesso = "Desconhecido";
        BufferedReader reader = null;

        try {
            // Construir o caminho para o arquivo cmdline do processo
            String caminhoCmdline = "/proc/" + pid + "/cmdline";

            // Ler o conteúdo do arquivo cmdline
            reader = new BufferedReader(new FileReader(caminhoCmdline));
            StringBuilder cmdline = new StringBuilder();
            int caractere;
            while ((caractere = reader.read()) != -1) {
                // O separador de argumentos no arquivo cmdline é '\0' (null byte)
                if (caractere == 0) {
                    // Adiciona espaço em vez de null byte
                    cmdline.append(' ');
                } else {
                    cmdline.append((char) caractere);
                }
            }

            // O nome do processo é o primeiro argumento no arquivo cmdline
            nomeDoProcesso = cmdline.toString().split("\\s+")[0];
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return nomeDoProcesso;
    }

    public String obterNomeDoProcessoPorPIDWindows(int pid) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();

        // Crie um snapshot de todos os processos atualmente em execução
        WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        try {
            // Percorra todos os processos no snapshot
            if (kernel32.Process32First(snapshot, processEntry)) {
                do {
                    // Verifique se o PID corresponde ao processo desejado
                    if (processEntry.th32ProcessID.intValue() == pid) {
                        // Se corresponder, retorne o nome do processo
                        return Native.toString(processEntry.szExeFile);
                    }
                } while (kernel32.Process32Next(snapshot, processEntry));
            }
        } finally {
            // Feche o snapshot após o uso
            kernel32.CloseHandle(snapshot);
        }

        // Se o processo não for encontrado, retorne null
        return null;
    }


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
