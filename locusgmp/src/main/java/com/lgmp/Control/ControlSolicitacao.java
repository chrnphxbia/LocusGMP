package com.lgmp.Control;

import com.lgmp.Entity.Imovel;
import com.lgmp.Entity.Solicitacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlSolicitacao {
    private List<Imovel> imoveis;
    private List<Solicitacao> solicitacoes;

    public ControlSolicitacao() {
        imoveis = new ArrayList<>();
        solicitacoes = new ArrayList<>();
        // Inicializar lista de imóveis e solicitações para exemplo
    }

    public List<Imovel> buscarImoveis() {
        return imoveis;
    }

    public Imovel getImovel(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        return null;
    }

    public Solicitacao criarSolicitacao(int imovelId, int hospedeId, Date dataInicio, Date dataFim, double valor) {
        Imovel imovel = getImovel(imovelId);
        // Obter hospedeId do banco de dados
        Solicitacao solicitacao = new Solicitacao(solicitacoes.size() + 1, imovel, null, dataInicio, dataFim, valor, "Pendente");
        solicitacoes.add(solicitacao);
        return solicitacao;
    }

    public String realizarPagamento(int solicitacaoId, double valor) {
        for (Solicitacao solicitacao : solicitacoes) {
            if (solicitacao.getId() == solicitacaoId && solicitacao.getValor() == valor) {
                solicitacao.setStatus("Pago");
                return "Pagamento realizado com sucesso.";
            }
        }
        return "Falha no pagamento.";
    }
}
