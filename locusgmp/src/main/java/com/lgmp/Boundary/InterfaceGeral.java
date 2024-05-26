package com.lgmp.Boundary;

import java.util.Scanner;

public class InterfaceGeral {
    private Scanner input = new Scanner(System.in);

    public void printMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    
    public void printMenuDeOpcoes(String Header, String[] opcoes) {
        System.out.println(Header);
        for(int i = 0; i < opcoes.length; i++) {
            System.out.println(opcoes[i]);
        }
    }

    public int receberOpcaoDoMenu(int[] opcoesValidas) {
        int escolha = -1;
        boolean flag = true;

        while (flag) {
            System.out.print("\nSelecione uma opção: ");
            try {
                escolha = Integer.parseInt(input.nextLine());
                for (int opcao : opcoesValidas) {
                    if (escolha == opcao) { flag = false; }
                }
                if(flag) {
                    System.out.println("Opção inválida. Tente novamente.");
                    escolha = -1;
                }
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return escolha;
    }
}
