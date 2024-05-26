package com.lgmp.Boundary;

public class InterfaceHospede extends InterfaceGeral{
    
    public void menuHospede(String nomeHospede) {
        super.printMensagem("\nBem-vindo, " + nomeHospede);
    }

    public int receberOpcaoHospede(int[] opcoesValidas) {
        return super.receberOpcaoDoMenu(opcoesValidas);
    }

}
