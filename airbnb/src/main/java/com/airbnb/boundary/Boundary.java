package com.airbnb.boundary;

import com.airbnb.control.Control;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Boundary {
    private Control control;

    public Boundary(Control control) {
        this.control = control;
    }

    public int cadastrarHospede(String nome) {
        return control.cadastrarHospede(nome);
    }

    public void buscarAnunciosDeReserva() {
        control.solicitarListaDeImoveis();
    }

    public void selecionarAnuncioParaReserva(int imovelId) {
        control.solicitarInformacoesDoImovel(imovelId);
    }

    public double definirDiasEsolicitarReserva(int hospedeId, int imovelId, String dataInicio, String dataFim) {
        LocalDate inicio = LocalDate.parse(dataInicio);
        LocalDate fim = LocalDate.parse(dataFim);
        long dias = ChronoUnit.DAYS.between(inicio, fim);

        double precoPorDia = control.getPrecoImovel(imovelId);
        double valor = dias * precoPorDia;

        control.solicitarReserva(hospedeId, imovelId, dataInicio, dataFim, valor);
        
        return valor;
    }

    public void realizarPagamento(int reservaId, double valor) {
        control.solicitarPagamento(reservaId, valor);
    }

    public int getUltimaReservaId() {
        return control.getUltimaReservaId();
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
