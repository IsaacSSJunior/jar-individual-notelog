package org.notelog.execute;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import org.notelog.entidades.cpu.Cpu;
import org.notelog.entidades.cpu.CpuDAO;
import org.notelog.entidades.disco.rigido.DiscoRigidoDAO;
import org.notelog.entidades.logs.cpu.LogCpu;
import org.notelog.entidades.logs.cpu.LogCpuDAO;
import org.notelog.entidades.logs.disco.LogDiscoDAO;
import org.notelog.entidades.logs.janelas.BloqueiaProcessos;
import org.notelog.entidades.logs.janelas.LogJanelasDAO;
import org.notelog.entidades.logs.ram.LogRam;
import org.notelog.entidades.logs.ram.LogRamDAO;
import org.notelog.entidades.notebook.Notebook;
import org.notelog.entidades.notebook.NotebookDAO;
import org.notelog.entidades.ram.Ram;
import org.notelog.entidades.ram.RamDAO;
import org.notelog.entidades.tempo.atividade.TempoDeAtividade;
import org.notelog.entidades.tempo.atividade.TempoDeAtividadeDAO;
import org.notelog.entidades.usuario.Usuario;
import org.notelog.entidades.usuario.UsuarioDAO;
import org.notelog.geolocalizacao.Geolocalizacao;
import org.notelog.geolocalizacao.GeolocalizacaoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Título em ASCII
        System.out.println("""
                            _____                   _______           _____                    _____                    _____     _______                   _____         \s
                           /\\    \\                 /::\\    \\         /\\    \\                  /\\    \\                  /\\    \\   /::\\    \\                 /\\    \\        \s
                          /::\\____\\               /::::\\    \\       /::\\    \\                /::\\    \\                /::\\____\\ /::::\\    \\               /::\\    \\       \s
                         /::::|   |              /::::::\\    \\      \\:::\\    \\              /::::\\    \\              /:::/    //::::::\\    \\             /::::\\    \\      \s
                        /:::::|   |             /::::::::\\    \\      \\:::\\    \\            /::::::\\    \\            /:::/    //::::::::\\    \\           /::::::\\    \\     \s
                       /::::::|   |            /:::/~~\\:::\\    \\      \\:::\\    \\          /:::/\\:::\\    \\          /:::/    //:::/~~\\:::\\    \\         /:::/\\:::\\    \\    \s
                      /:::/|::|   |           /:::/    \\:::\\    \\      \\:::\\    \\        /:::/__\\:::\\    \\        /:::/    //:::/    \\:::\\    \\       /:::/  \\:::\\    \\   \s
                     /:::/ |::|   |          /:::/    / \\:::\\    \\     /::::\\    \\      /::::\\   \\:::\\    \\      /:::/    //:::/    / \\:::\\    \\     /:::/    \\:::\\    \\  \s
                    /:::/  |::|   | _____   /:::/____/   \\:::\\____\\   /::::::\\    \\    /::::::\\   \\:::\\    \\    /:::/    //:::/____/   \\:::\\____\\   /:::/    / \\:::\\    \\ \s
                   /:::/   |::|   |/\\    \\ |:::|    |     |:::|    | /:::/\\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/    /|:::|    |     |:::|    | /:::/    /   \\:::\\ ___\\\s
                  /:: /    |::|   /::\\____\\|:::|____|     |:::|    |/:::/  \\:::\\____\\/:::/__\\:::\\   \\:::\\____\\/:::/____/ |:::|____|     |:::|    |/:::/____/  ___\\:::|    |
                  \\::/    /|::|  /:::/    / \\:::\\    \\   /:::/    //:::/    \\::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\    \\  \\:::\\    \\   /:::/    / \\:::\\    \\ /\\  /:::|____|
                   \\/____/ |::| /:::/    /   \\:::\\    \\ /:::/    //:::/    / \\/____/  \\:::\\   \\:::\\   \\/____/  \\:::\\    \\  \\:::\\    \\ /:::/    /   \\:::\\    /::\\ \\::/    /\s
                           |::|/:::/    /     \\:::\\    /:::/    //:::/    /            \\:::\\   \\:::\\    \\       \\:::\\    \\  \\:::\\    /:::/    /     \\:::\\   \\:::\\ \\/____/ \s
                           |::::::/    /       \\:::\\__/:::/    //:::/    /              \\:::\\   \\:::\\____\\       \\:::\\    \\  \\:::\\__/:::/    /       \\:::\\   \\:::\\____\\   \s
                           |:::::/    /         \\::::::::/    / \\::/    /                \\:::\\   \\::/    /        \\:::\\    \\  \\::::::::/    /         \\:::\\  /:::/    /   \s
                           |::::/    /           \\::::::/    /   \\/____/                  \\:::\\   \\/____/          \\:::\\    \\  \\::::::/    /           \\:::\\/:::/    /    \s
                           /:::/    /             \\::::/    /                              \\:::\\    \\               \\:::\\    \\  \\::::/    /             \\::::::/    /     \s
                          /:::/    /               \\::/____/                                \\:::\\____\\               \\:::\\____\\  \\::/____/               \\::::/    /      \s
                          \\::/    /                 ~~                                       \\::/    /                \\::/    /   ~~                      \\::/____/       \s
                           \\/____/                                                            \\/____/                  \\/____/                                            \s
                                                                                                                                                                          \s
                """);
        System.out.println("Solução de monitoramento para notebooks - Notelog 0.18.2 (Versão Alpha)");

        Thread.sleep(3000);
        Scanner scanner = new Scanner(System.in);

        // Loop de login
        boolean loginValido = false;
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario usuario = null;

        while (!loginValido) {
            System.out.println("Por favor, faça login para continuar...");
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            // Verifica se o usuário existe no banco de dados
            usuario = userDAO.verificaUsuario(email, senha);
            if (usuario != null) {
                loginValido = true;
                System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome() + "!");
                Thread.sleep(3000);
                escolherMonitoramento(usuario);
            } else {
                System.out.println("Email ou senha incorretos. Tente novamente.");
            }
        }
    }

        private static void inserirDadosNoBanco(Usuario usuario) throws InterruptedException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Monitorando dispositivo, que tal um café enquanto isso?...");
            System.out.println("Deseja parar encerrar o programa? Digite 'exit'.");

            if (scanner.nextLine().equalsIgnoreCase("exit")) {
                return;
            }


            while (true) {
                try {
                    //Geolocalização
                    Geolocalizacao geolocalizacao = new Geolocalizacao();
                    String publicIPAddress = geolocalizacao.ObterIP();
                    String jsonString = geolocalizacao.ObterGeoPorIP(publicIPAddress);
                    geolocalizacao.preencherDados(jsonString);
                    String dadosFormatados = geolocalizacao.formatarDados();
                    Thread.sleep(5000);
                    Thread.sleep(10000); // Espera 10 segundo

                    //funcionalidade de Processos bloqueados

                    //DAO - Instancias
                    NotebookDAO notebookDAO = new NotebookDAO();
                    CpuDAO cpuDAO = new CpuDAO();
                    RamDAO ramDAO = new RamDAO();
                    DiscoRigidoDAO discoRigidoDAO = new DiscoRigidoDAO();
                    TempoDeAtividadeDAO tempoDeAtividadeDAO = new TempoDeAtividadeDAO();
//                  GeolocalizacaoDAO geoDAO = new GeolocalizacaoDAO();


                    //DAO - Metodos
                    notebookDAO.adicionarNotebook(new Notebook());
                    cpuDAO.adicionarCpu(new Cpu());
                    ramDAO.adicionarRam(new Ram());
                    discoRigidoDAO.adiconarNovoDisco();
                    tempoDeAtividadeDAO.adicionarTempoDeAtividade(new TempoDeAtividade());


                    //Logs

                    //LogDAO - Instancias
                    LogCpuDAO logCpuDAO = new LogCpuDAO();
                    LogRamDAO logRamDAO = new LogRamDAO();
                    LogDiscoDAO logDiscoDAO = new LogDiscoDAO();
                    LogJanelasDAO logJanelasDAO = new LogJanelasDAO();


                    //LogDAO - Metodos
                    logCpuDAO.adicionarLogCpu(new LogCpu());
                    logRamDAO.adicionarLogRam(new LogRam());
                    logDiscoDAO.adiconarNovoLogDisco();
                    logJanelasDAO.adicionarNovoLogJanelas();
//                    geoDAO.adicionaGeolocalizacao();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }



    private static void escolherMonitoramento(Usuario usuario) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Selecione o tipo de monitoramento:");
            System.out.println("1 - Monitorar CPU");
            System.out.println("2 - Monitorar Disco");
            System.out.println("3 - Monitorar Janelas");
            System.out.println("4 - Monitorar RAM");
            System.out.println("5 - Capturar Geolocalização do dispositivo");
            System.out.println("6 - Ocultar ação do Notelog");
            System.out.println("7 - Bloquear processos indevidos");
            System.out.println("8 - Sair do programa");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    monitorarCPU(usuario);
                    break;
                case 2:
                    monitorarDisco(usuario);
                    break;
                case 3:
                    monitorarJanelas(usuario);
                    break;
                case 4:
                    monitorarRAM(usuario);
                    break;
                case 5:
                    monitorarGeolocalizacao(usuario);
                    break;
                case 6:
                    System.out.println("Os inserts continuaram sendo executados, porém de forma invisivel");
                    inserirDadosNoBanco(usuario);
                    break;
                case 7:
                    bloquearProcessosindevidos(usuario);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);
        System.out.println("Programa Finalizado.");
    }

    // Funções de monitoramento
    private static void monitorarCPU(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Looca looca = new Looca();
        do {
            System.out.println("Monitorando CPU...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Dados de CPU:");
            try {
                Thread.sleep(5000);
                System.out.println(looca.getProcessador().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Inserindo processos no Banco...");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Concluido!!");
        } while (!scanner.nextLine().equalsIgnoreCase("exit"));
        System.out.println("Saindo do monitoramento de CPU...");

        try {
            escolherMonitoramento(usuario);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void monitorarDisco(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Looca looca = new Looca();
        do {
            System.out.println("Monitorando Disco...");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Dados de Discos:");
            try {
                Thread.sleep(5000);
                System.out.println(looca.getGrupoDeDiscos().getDiscos().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Inserindo processos no Banco...");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Concluido!!");
        } while (!scanner.nextLine().equalsIgnoreCase("exit"));
        System.out.println("Saindo do monitoramento de Disco...");

        try {
            escolherMonitoramento(usuario);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    private static void monitorarJanelas(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Looca looca = new Looca();
        do {
            System.out.println("Monitorando Janelas...");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Dados de Janelas:");
            try {
                Thread.sleep(5000); // Espera 5 segundos
                System.out.println(looca.getGrupoDeJanelas().getJanelas().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Inserindo processos no Banco...");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Concluido!!");
        } while (!scanner.nextLine().equalsIgnoreCase("exit"));
        System.out.println("Saindo do monitoramento de Janelas...");

        try {
            escolherMonitoramento(usuario);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    private static void monitorarRAM(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Looca looca = new Looca();
        do {

            System.out.println("Monitorando RAM...");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Dados de memória RAM:");
            try {
                Thread.sleep(5000); // Espera 5 segundos
                looca.getMemoria().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Inserindo processos no Banco...");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Concluido!!");
        } while (!scanner.nextLine().equalsIgnoreCase("exit"));
        System.out.println("Saindo do monitoramento de RAM...");

        try {
            escolherMonitoramento(usuario);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void monitorarGeolocalizacao(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Geolocalizacao geolocalizacao = new Geolocalizacao();
                GeolocalizacaoDAO geoDAO = new GeolocalizacaoDAO();

                String publicIPAddress = geolocalizacao.ObterIP();
                String jsonString = geolocalizacao.ObterGeoPorIP(publicIPAddress);

                geolocalizacao.preencherDados(jsonString);
                String dadosFormatados = geolocalizacao.formatarDados();
                System.out.println("Geolocalização do dispositivo:");
                Thread.sleep(1000); // Espera 1 segundo
                System.out.println(dadosFormatados);
                Thread.sleep(5000); // Espera 5 segundos
                System.out.println("Dados capturados com sucesso.");
//                geoDAO.adicionaGeolocalizacao();
                return;

            } catch (InterruptedException e) {}
        }
    }

    private static void bloquearProcessosindevidos(Usuario usuario) throws InterruptedException, IOException {
        // Thread para verificar e encerrar processos bloqueados
            while (true) {
//                try {
                    Looca processGroup = new Looca();
                    BloqueiaProcessos func = new BloqueiaProcessos();

                    List<String> processosBloqueados = new ArrayList<>();

                    String processoDaVez;

                    processosBloqueados.add("Spotify");

                    for (Processo process : processGroup.getGrupoDeProcessos().getProcessos()) {

                        for (int i = 0; i < processosBloqueados.size(); i ++) {
                            processoDaVez = func.obterNomeDoProcessoPorPIDLixux(process.getPid());
                            if (processoDaVez.contains(processosBloqueados.get(i))) {
                                func.encerraProcesso(Math.toIntExact(process.getPid()));
                                System.out.println("Processo " + process.getNome() + " foi encerrado por violar as políticas da empresa!");
                                Thread.sleep(3000);
                            }

                        }
                    }

                    return;


//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

    }


}
