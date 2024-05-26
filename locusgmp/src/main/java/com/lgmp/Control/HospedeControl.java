package com.lgmp.Control;

import com.lgmp.Boundary.InterfaceHospede;
import com.lgmp.Entities.Hospede;

public class HospedeControl {
    private Hospede exemploHospede;
    private InterfaceHospede hospedeInterface;
    
    public HospedeControl() {
        this.hospedeInterface = new InterfaceHospede();
        this.exemploHospede = new Hospede("guiischulz12", "delrey", "Guilherme Schulz");
    }

    public void controling() {
        int[] acoesValidas = {1,2,3};
        String[] acoesHospede = {"01. Buscar imóveis para reserva", "02. Ver suas reservas", "03. Encerrar"};
        hospedeInterface.menuHospede(exemploHospede.getName());
        hospedeInterface.printMenuDeOpcoes("Selecione uma opção", acoesHospede);
        int escolhaHospede = hospedeInterface.receberOpcaoDoMenu(acoesValidas);
    }
}
