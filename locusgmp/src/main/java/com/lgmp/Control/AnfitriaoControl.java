package com.lgmp.Control;

import com.lgmp.Boundary.InterfaceAnfitriao;
import com.lgmp.Entities.Anfitriao;

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
        "02. Minhas reservas", "03. Encerrar"};
        anfitriaoInterface.menuAnfitriao(exemploAnfitriao.getName());
        anfitriaoInterface.printMenuDeOpcoes("Selecione uma opção: ", acoesAnfitriao);
        int escolhaAnfitriao = anfitriaoInterface.receberOpcaoAnfitriao(acoesValidas);
    }

}
