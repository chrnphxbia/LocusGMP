package com.airbnb.boundary;

import com.airbnb.control.Control;

public class Boundary {
    private Control control;

    public Boundary(Control control) {
        this.control = control;
    }

    public void buscarAnunciosDeReserva() {
        control.solicitarListaDeImoveis();
    }

    public void selecionarAnuncioParaReserva(int imovelId) {
        control.solicitarInformacoesDoImovel(imovelId);
    }

    public void definirDiasEsolicitarReserva(int imovelId, String dataInicio, String dataFim) {
        control.solicitarReserva(imovelId, dataInicio, dataFim);
    }

    public void realizarPagamento(int reservaId, double valor) {
        control.solicitarPagamento(reservaId, valor);
    }

    public void selecionarReservaParaAvaliacao(int reservaId) {
        control.selecionarReservaParaAvaliacao(reservaId);
    }

    public void avaliarSolicitacaoDeReserva(int reservaId, boolean aceita) {
        control.avaliarSolicitacaoDeReserva(reservaId, aceita);
    }

    public void cancelarReserva(int reservaId, String motivo) {
        control.cancelarReserva(reservaId, motivo);
    }

    public void recursoPorDanosAoImovel(int reservaId, String descricaoDanos) {
        control.registrarRecursoPorDanos(reservaId, descricaoDanos);
    }
}
