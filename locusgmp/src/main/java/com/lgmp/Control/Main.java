package com.lgmp.Control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.lgmp.Entity.*;

public class Main {
    private static Scanner input = new Scanner(System.in);

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

    public static void popularAnfitriao(Anfitriao anfitriao) {
        ArrayList<Integer> datas = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        Imovel imovel01 = new Imovel("im01", "Hotel California", "Reservado", "California", 200, 2, anfitriao, datas);
        Imovel imovel02 = new Imovel("im02", "Pousada Schulz", "Pendente", "São Paulo", 700, 3, anfitriao, datas);
        Imovel imovel03 = new Imovel("im03", "Hotel Seu Zé", "Disponível", "Rio de Janeiro", 50, 5, anfitriao, datas);

        anfitriao.addImovel(imovel01);
        anfitriao.addImovel(imovel02);
        anfitriao.addImovel(imovel03);
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

    public static void main(String[] args) {
        int[] opcoesValidas = { 1, 2, 3 };
        boolean flag = true;
        System.out.println("Bem-vindo ao LocusGMP!");

        while (flag) {

            System.out.println("01. Hóspede\n02. Anfitrião\n03. Encerrar");
            int opcaoEscolhida = receberOpcaoMenu(opcoesValidas);
            switch (opcaoEscolhida) {
                case 1:
                    // hospede
                    break;

                case 2:
                    boolean flagAnfitriao = true;
                    Anfitriao anfitriaoTeste = new Anfitriao("pedrohe7721", "12345", "Pedro");
                    popularAnfitriao(anfitriaoTeste);

                    while (flagAnfitriao) {
                        System.out.println("01. Solicitações de reserva\n02. Meus imóveis\n03. Voltar");
                        int[] opcoesAnfitriao = { 1, 2, 3 };
                        int opcaoAnfitriao = receberOpcaoMenu(opcoesAnfitriao);

                        switch (opcaoAnfitriao) {
                            case 1:
                                // solicitacoes
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
                                            System.out.println("Selecione um motivo para o cancelamento: ");
                                            System.out.println("01. Reagendamento de evento do imóvel\n02. Interrupção de" +
                                                "serviços essenciais\n03. Não me sinto à vontade com o Hóspede\n04. Anunciei o" + 
                                                "imóvel por engano\n05. Outro");
                                            double multa = 0;
                                            int[] opcoesValidasCancelamento = {1,2,3,4,5};
                                            int opcaoCancelamento = receberOpcaoMenu(opcoesValidasCancelamento);
                                            
                                            if(opcaoCancelamento != 2) { multa = 0.25; }
                                            

                                            break;

                                        case 2:
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
