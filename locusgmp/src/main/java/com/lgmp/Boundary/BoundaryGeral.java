package com.lgmp.Boundary;

import java.util.Scanner;

public class BoundaryGeral {
    Scanner input = new Scanner(System.in);

    public void exibeMenuInicial() {
        
    }
    
    public String receberEntrada(String query) {
        System.out.println(query);
        return input.nextLine();
    }

    public int receberOpcaoMenu(String menu, int[] opcoesValidas) {
        System.out.println(menu);
        int opcaoEscolhida = -1;
        boolean flag = true;

        while (flag) {
            System.out.println("Insira uma opção: ");
            try {
                opcaoEscolhida = Integer.parseInt(input.nextLine());
                for (int opcao : opcoesValidas) {
                    if(opcaoEscolhida == opcao) {
                        flag = false;
                    }
                }

                if(flag) { System.out.println("Opção inválida. Tente novamente."); }
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return opcaoEscolhida;
    }

}
