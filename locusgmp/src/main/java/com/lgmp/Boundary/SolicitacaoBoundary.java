package com.lgmp.Boundary;

import com.lgmp.Control.ControlSolicitacao;
import com.lgmp.Entity.Imovel;
import com.lgmp.Entity.Solicitacao;

import java.util.Date;
import java.util.List;

public class SolicitacaoBoundary {
    private ControlSolicitacao controlSolicitacao;

    public SolicitacaoBoundary() {
        controlSolicitacao = new ControlSolicitacao();
    }

    public List<Imovel> buscarImoveis() {
        return controlSolicitacao.buscarImoveis();
    }

    public Imovel exibirInformacoesImovel(int id) {
        return controlSolicitacao.getImovel(id);
    }

    public Solicitacao criarSolicitacao(int imovelId, int hospedeId, Date dataInicio, Date dataFim, double valor) {
        return controlSolicitacao.criarSolicitacao(imovelId, hospedeId, dataInicio, dataFim, valor);
    }

    public String realizarPagamento(int solicitacaoId, double valor) {
        return controlSolicitacao.realizarPagamento(solicitacaoId, valor);
    }
}
