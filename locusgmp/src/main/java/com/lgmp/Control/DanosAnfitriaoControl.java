package com.lgmp.Control;

import Entity.Imovel;
import Entity.Danos;
import Entity.Compensacao;
//colocar Boudary

public class DanosAnfitriaoControl {

    private Solicitacao exemploSolicitacao;
    //private da boudary

    public DanosAnfitriaoControl() {
        //this.boudary = new boudary();
        this.exemploSolicitacao = new Solicitacao("S1", "Quuebraram meu vaso, estava no chão do imóvel em cacos", 250.00);
    }

    public Compensacao criarSolicitacao(String idSolicitacao, String descricao, float valor) {
        return new Solicitacao(idSolicitacao, descricao, valor);
    }

    public void controling() {

    }
}
