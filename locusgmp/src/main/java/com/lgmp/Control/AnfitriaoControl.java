package com.lgmp.Control;

import com.lgmp.Boundary.InterfaceAnfitriao;
import com.lgmp.Entities.Anfitriao;
import com.lgmp.Entities.Imovel;

public class AnfitriaoControl {
    private Anfitriao exemploAnfitriao;
    private InterfaceAnfitriao anfitriaoInterface;
    
    public AnfitriaoControl() {
        this.anfitriaoInterface = new InterfaceAnfitriao();
        this.exemploAnfitriao = new Anfitriao("mariaki", "holl0wknight", "Marina Martin");
    }

    public void controling() {
        int[] acoesValidas = {1,2,3};
        String[] acoesAnfitriao = {"01. Notificação de solicitação de reserva", 
        "02. Meus imóveis", "03. Voltar"};

        anfitriaoInterface.menuAnfitriao(exemploAnfitriao.getName());
        anfitriaoInterface.printMenuDeOpcoes("\nSelecione uma opção: ", acoesAnfitriao);

        int escolhaAnfitriao = anfitriaoInterface.receberOpcaoAnfitriao(acoesValidas);

        switch (escolhaAnfitriao) {
            case 1:
                System.out.println("Avaliar solicitação");
                break;
            
            case 2:
                Imovel teste = new Imovel("063hb", "AirBNB", 553.4f, "disponivel", "Sao Paulo", "aluga ai", 2);
                exemploAnfitriao.addImovel(teste);
                System.out.println(exemploAnfitriao.getImoveis());
                break;

            default:
                break;
        }
    }

}
