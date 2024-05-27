package com.airbnb.control;

import com.airbnb.entity.Entity;
import com.airbnb.model.Imovel;

public class Control {
    private Entity entity;

    public Control(Entity entity) {
        this.entity = entity;
    }

    public void solicitarListaDeImoveis() {
        entity.recuperarImoveis();
    }

    public void solicitarInformacoesDoImovel(int imovelId) {
        entity.recuperarInformacoesDoImovel(imovelId);
    }

    public double getPrecoImovel(int imovelId) {
        return entity.getPrecoImovel(imovelId);
    }

    public void solicitarReserva(int imovelId, String dataInicio, String dataFim) {
        entity.criarReserva(imovelId, dataInicio, dataFim);
    }

    public void solicitarPagamento(int reservaId, double valor) {
        entity.registrarPagamento(reservaId, valor);
    }

    public void selecionarReservaParaAvaliacao(int reservaId) {
        entity.recuperarDetalhesDaReserva(reservaId);
    }

    public void avaliarSolicitacaoDeReserva(int reservaId, boolean aceita) {
        if (aceita) {
            entity.atualizarStatusDaReserva(reservaId, "Aceita");
        } else {
            entity.atualizarStatusDaReserva(reservaId, "Rejeitada");
        }
    }

    public void cancelarReserva(int reservaId, String motivo) {
        entity.cancelarReserva(reservaId, motivo);
    }

    public void registrarRecursoPorDanos(int reservaId, String descricaoDanos) {
        entity.registrarRecursoPorDanos(reservaId, descricaoDanos);
    }
}
