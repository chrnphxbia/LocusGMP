package com.lgmp.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.lgmp.Entity.*;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Hospede hospede03;
    private static Hospede hospede02;
    private static Hospede hospede01;

    public static String receberEntrada(String query) {
        System.out.println(query);
        return input.nextLine();
    }

    public static int receberOpcaoMenu(int[] opcoesValidas) {
        int opcaoEscolhida = -1;
        boolean flag = true;

        while (flag) {
            System.out.print("Insira uma opção: ");
            try {
                opcaoEscolhida = Integer.parseInt(input.nextLine());
                for (int opcao : opcoesValidas) {
                    if (opcaoEscolhida == opcao) {
                        flag = false;
                    }
                }

                if (flag) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return opcaoEscolhida;
    }

    public static void popula(Anfitriao anfitriao) {
        ArrayList<Integer> datas = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        
        Hospede hospede1 = new Hospede("JocaMaster", "senha", "Joca");
        Hospede hospede2 = new Hospede("LucasLegal", "senha", "Lucas");
        Hospede hospede3 = new Hospede("MariaMaria", "senha", "Maria");
        Hospede hospede4 = new Hospede("JORGEJORGE", "senha", "Jorge");
        
        Imovel imovel01 = new Imovel("im01", "Hotel California", "Reservado", "California", 200, 2, anfitriao, datas, null);
        Imovel imovel02 = new Imovel("im02", "Pousada Schulz", "Pendente", "São Paulo", 700, 3, anfitriao, datas, null);
        Imovel imovel03 = new Imovel("im03", "Hotel Seu Zé", "Disponível", "Rio de Janeiro", 50, 5, anfitriao, datas, null);
        Imovel imovel04 = new Imovel("im04", "Hotelzin zin", "Disponível", "Rio de lindoinha", 300, 5, anfitriao, datas, null);


        // Then create Reserva objects using the defined Imovel objects
        Reserva reserva1 = new Reserva("r01", "Ativa", imovel01, hospede1, 20, 25, 2);
        Reserva reserva2 = new Reserva("r02", "Ativa", imovel02, hospede2, 23, 25, 2);
        Reserva reserva3 = new Reserva("r03", "Cancelada", imovel03, hospede3, 13, 25, 2);
        Reserva reserva4 = new Reserva("r04", "Finalizada", imovel04, hospede4, 13, 25, 2);

        Solicitacao solicitacao1 = new Solicitacao(1, imovel01, hospede02, 3, 700, "Pendente");
        Solicitacao solicitacao2 = new Solicitacao(2, imovel02, hospede02, 3, 700, "Pendente");
        Solicitacao solicitacao3 = new Solicitacao(3, imovel03, hospede02, 5, 700, "Pendente");

        // Add Reservas objects to the Hospede
        anfitriao.addImovel(imovel01);
        anfitriao.addImovel(imovel02);
        anfitriao.addImovel(imovel03);
        anfitriao.addImovel(imovel04);

        // Set Imovel objects for the Reserva objects
        imovel01.setreserva(reserva1);
        imovel02.setreserva(reserva2);
        imovel03.setreserva(reserva3);
        imovel04.setreserva(reserva4);

        hospede1.addReserva(reserva1);
        hospede2.addReserva(reserva2);
        hospede3.addReserva(reserva3);
        hospede4.addReserva(reserva4);
        
    }

    public static void popula(Hospede hospede) {
        ArrayList<Integer> datas = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7));

                
        Anfitriao anfitriao1 = new Anfitriao("Jubileuleu", "senha", "Jubileu");
        Anfitriao anfitriao2 = new Anfitriao("Jalalal", "senha", "Jamil");
        Anfitriao anfitriao3 = new Anfitriao("Joojmen", "senha", "Jaime");
        Anfitriao anfitriao4 = new Anfitriao("SilvinhaXD", "senha", "Silvia");

        
        Imovel imovel01 = new Imovel("im01", "Hotel California", "Reservado", "California", 200, 2, anfitriao1, datas, null);
        Imovel imovel02 = new Imovel("im02", "Pousada Schulz", "Pendente", "São Paulo", 700, 3, anfitriao2, datas, null);
        Imovel imovel03 = new Imovel("im03", "Hotel Seu Zé", "Disponível", "Rio de Janeiro", 50, 5, anfitriao3, datas, null);
        Imovel imovel04 = new Imovel("im04", "Hotelzin zin", "Disponível", "Rio de lindoinha", 300, 5, anfitriao4, datas, null);


        // Then create Reserva objects using the defined Imovel objects
        Reserva reserva1 = new Reserva("r01", "Ativa", imovel01, hospede, 20, 25, 2);
        Reserva reserva2 = new Reserva("r02", "Ativa", imovel02, hospede, 23, 25, 2);
        Reserva reserva3 = new Reserva("r03", "Cancelada", imovel03, hospede, 13, 25, 2);
        Reserva reserva4 = new Reserva("r04", "Finalizada", imovel04, hospede, 13, 25, 2);

        // Set Imovel objects for the Reserva objects
        imovel01.setreserva(reserva1);
        imovel02.setreserva(reserva2);
        imovel03.setreserva(reserva3);
        imovel04.setreserva(reserva4);

        hospede.addReserva(reserva1);
        hospede.addReserva(reserva2);
        hospede.addReserva(reserva3);
        hospede.addReserva(reserva4);

        anfitriao1.addImovel(imovel01);
        anfitriao2.addImovel(imovel02);
        anfitriao3.addImovel(imovel03);
        anfitriao4.addImovel(imovel04);
        
    }

    public static ArrayList<Reserva> geraListaReservasFinalizadas(Anfitriao anfitriao) {
        ArrayList<Reserva> reservasFinalizas = new ArrayList<>();
        

        for (Reserva reserva : anfitriao.getReservas()) {
            if(reserva.getStatus() == "Finalizada") {
                reservasFinalizas.add(reserva);
            }
        }

        return reservasFinalizas;
    }

    public static ArrayList<Imovel> geraListaReservas(Anfitriao anfitriao) {
        ArrayList<Imovel> imoveisReservados = new ArrayList<>();

        for (Imovel imovel : anfitriao.getImoveis()) {
            if(imovel.getStatus() == "Reservado") {
                imoveisReservados.add(imovel);
            }
        }

        return imoveisReservados;
    }


    public static ArrayList<Reserva> geraReservas(Hospede hospede) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        for (Reserva reserva : hospede.getReservas()) {
            if(reserva.getStatus() == "Ativa") {
                reservas.add(reserva);
            }
        }

        return reservas;
    }


    public static ArrayList<Solicitacao> geraListaSolicitacao(Anfitriao anfitriao) {
            ArrayList<Imovel> solicitacaoPendente = new ArrayList<>();

        for (Solicitacao solicitacao : anfitriao.getSolicitacao()) {
            if(solicitacao.getStatus() == "Pendente") {
                solicitacaoPendente.add(solicitacao);
            }
        }

        return solicitacaoPendente;
    }

    public static void main(String[] args) {
        int[] opcoesValidas = { 1, 2, 3 };
        boolean flag = true;
        System.out.println("Bem-vindo ao LocusGMP!");

        while (flag) {

            System.out.println("01. Hóspede\n02. Anfitrião\n03. Encerrar");
            int opcaoEscolhida = receberOpcaoMenu(opcoesValidas);
            switch (opcaoEscolhida) {
                case 1: // hospede
                    boolean flagHospede = true;
                    Anfitriao anfitriaoTeste2 = new Anfitriao("julio7721", "12345", "julio");
                    Hospede hospedeTeste = new Hospede("Marinazinha", "12345", "Marina");
                    
                    popula(anfitriaoTeste2);
                    popula(hospedeTeste);
                    
                    while (flagHospede) {
                        System.out.println("01. Reservar \n02. Minhas Reservas\n03. Voltar");
                        int[] opcoesHospede = { 1, 2, 3 };
                        int opcaoHospede = receberOpcaoMenu(opcoesHospede);
                        
                        switch (opcaoHospede){
                            case 1: 
                                //RESERVAS GUILHERME AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                                break;

                            case 2: //ver reservas
                                boolean flagVerReservas = true;
                                System.out.println(hospedeTeste.getReservasLista());
                                while (flagVerReservas) {
                                    System.out.println("01. Cancelar reserva\n02. Voltar");
                                    opcaoHospede = receberOpcaoMenu(opcoesValidas);
                                    switch(opcaoHospede){
                                        case 1:
                                            ArrayList<Reserva> reservas = geraReservas(hospedeTeste);
                                            
                                            System.out.println(reservas);
                                            String idEscolhido3 = receberEntrada("Qual reserva deseja cancelar? (ID)");


                                            boolean reservaEncontrada = false;
                                            for (Reserva reserva : hospedeTeste.getReservas()) {
                                                if (reserva.getID().equals(idEscolhido3)) { 
                                                    reserva.setStatus("Cancelada");
                                                    reserva.getImovel().setStatus("Disponível");
                                                    reservaEncontrada = true;
                                                    break;
                                                }
                                            }

                                            if (reservaEncontrada) {
                                                System.out.println("Reserva cancelada com sucesso!");
                                            } else {
                                                System.out.println("Reserva não encontrada.");
                                            }
                                            break;

                                        default:
                                            flagVerReservas = false;
                                            break;
                                    }
                                }
                            default:
                                flagHospede = false;
                                break;
                        }
                    break;
                }

                case 2:
                    boolean flagAnfitriao = true;
                    Anfitriao anfitriaoTeste = new Anfitriao("pedrohe7721", "12345", "Pedro");
                    popula(anfitriaoTeste);

                    while (flagAnfitriao) {
                        System.out.println("01. Solicitações de reserva\n02. Meus imóveis\n03. Voltar");
                        int[] opcoesAnfitriao = { 1, 2, 3 };
                        int opcaoAnfitriao = receberOpcaoMenu(opcoesAnfitriao);

                        switch (opcaoAnfitriao) {
                            case 1: // solicitacoes
                                /*flagSolicitacoes = true;
                                System.out.println(anfitriaoTeste.getsolicitacaoPendente());

                                flagSolicitacoes = false;    */
                                break;

                            case 2: // ver imoveis
                                boolean flagVerImoveis = true;
                                System.out.println(anfitriaoTeste.getImoveisLista());
                                
                                while (flagVerImoveis) {
                                    System.out.println("01. Cancelar reserva\n02. Entrar com recurso\n03. Voltar");
                                    opcaoAnfitriao = receberOpcaoMenu(opcoesValidas);

                                    switch (opcaoAnfitriao) {
                                        case 1:
                                        ArrayList<Imovel> imoveisReservados = geraListaReservas(anfitriaoTeste);

                                        System.out.println(imoveisReservados);
                                        String idEscolhido = receberEntrada("Qual reserva deseja cancelar? (ID)");
                                        
                                        
                                        boolean reservaEncontrada = false;
                                        for (Imovel imovel : anfitriaoTeste.getImoveis()) {
                                            if (imovel.getStatus().equals("Reservado")) { 
                                                if (imovel.getID().equals(idEscolhido)) { 
                                                    
                                                    imovel.setStatus("Disponível");
                                                    imovel.getreserva().setStatus("Cancelada");

                                                    reservaEncontrada = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (reservaEncontrada) {
                                            System.out.println("Reserva cancelada com sucesso!");
                                        } else {
                                            System.out.println("Reserva não encontrada ou imóvel não está reservado.");
                                        }
                                        break;

                                        case 2:
                                            ArrayList<Reserva> reservasFinalizadas = geraListaReservasFinalizadas(anfitriaoTeste);

                                            System.out.println(reservasFinalizadas);
                                            String idEscolhido2 = receberEntrada("Qual reserva você deseja abrir recurso para recompensação financeira por danos?");

                                            //for (Reserva reserva : anfitriaoTeste.getImoveis().getReservas()) {
                                            for(Reserva reserva: reservasFinalizadas){
                                            if (reserva.getStatus().equals("Finalizada")) { 
                                                if (reserva.getID().equals(idEscolhido2)) { 
                                                    
                                                    
                                                    //imovel.setStatus("Disponível");
                                                    //imovel.getreserva().setStatus("Cancelada");

                                                    break;
                                                }
                                            }
                                            }
                                            
                                            //Marina 
                                            System.out.println("recurso");
                                            break;

                                        default:
                                            flagVerImoveis = false;
                                            break;
                                    }
                                }
                                break;

                            default:
                                flagAnfitriao = false;
                                break;
                        }
                    }
                    break;

                default:
                    flag = false;
                    break;
            }
        }
    }
}
