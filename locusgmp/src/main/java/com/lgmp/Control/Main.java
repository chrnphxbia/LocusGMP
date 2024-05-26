package com.lgmp.Control;

import com.lgmp.Boundary.InterfaceGeral;

public class Main {
    private static AnfitriaoControl controlAnfitriao = new AnfitriaoControl();
    private static HospedeControl controlHospede = new HospedeControl();
    private static InterfaceGeral mainBoundary = new InterfaceGeral();
    public static void main(String[] args) {
        boolean execFlag = true;
        int[] opcoesValidas = {1,2,3};
        String[] opcoes = {"01. Hóspede", "02. Anfitrião", "03. Encerrar"};

        mainBoundary.printMensagem("\tBem-vindo ao LocusGMP!\n");

        while (execFlag) {
            mainBoundary.printMenuDeOpcoes("Selecione o agente do caso de uso.", opcoes);
            int escolha = mainBoundary.receberOpcaoDoMenu(opcoesValidas);

            switch (escolha) {
                case 1: // Hóspede
                    controlHospede.control();
                    break;
            
                case 2:
                    System.out.println("=)");
                    break;

                default:
                    execFlag = false;
                    break;
            }
        }

        mainBoundary.printMensagem("\n\tObrigado por usar o LocusGMP!");
    }
}
