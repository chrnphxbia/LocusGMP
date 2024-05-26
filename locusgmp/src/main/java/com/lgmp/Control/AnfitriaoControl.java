package com.lgmp.Control;

import com.lgmp.Boundary.InterfaceAnfitriao;
import com.lgmp.Entities.Anfitriao;

public class AnfitriaoControl {
    private Anfitriao exemploAnfitriao;
    private InterfaceAnfitriao anfitriaoInterface;

    public void controling() {
        int[] acoesValidas = {1,2,3,4};
        String[] acoesAnfitriao = {"01. Notificação de solicitação de reserva", 
        "02. Meus imóveis", "03. Fazer uma solicitação de compensação por danos ao imóvel e seus pertences", "04. Voltar"};

        anfitriaoInterface.menuAnfitriao(exemploAnfitriao.getName());
        anfitriaoInterface.printMenuDeOpcoes("\nSelecione uma opção: ", acoesAnfitriao);

        int escolhaAnfitriao = anfitriaoInterface.receberOpcaoAnfitriao(acoesValidas);

        switch (escolhaAnfitriao) {
            case 1:
                System.out.println("Avaliar solicitação");
                break;
            
            case 2:
                
                break;

            case 3:
                //ir para DanosAntifitriaoControl

            default:
                break;
        }
    }

}
