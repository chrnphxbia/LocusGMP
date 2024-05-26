package com.lgmp.Boundary;

public class InterfaceAnfitriao extends InterfaceGeral{
    
    public void menuAnfitriao(String nomeAnfitriao) {
        super.printMensagem("\nBem-vindo, " + nomeAnfitriao);
    }

    public int receberOpcaoAnfitriao(int[] opcoesValidas) {
        return super.receberOpcaoDoMenu(opcoesValidas);
    }

}
