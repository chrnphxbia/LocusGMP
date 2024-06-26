package com.airbnb.control;

import com.airbnb.entity.Entity;
import com.airbnb.model.Reserva;

import java.time.LocalDate;

public class Control {
    private Entity entity;

    public Control(Entity entity) {
        this.entity = entity;
    }

    public int cadastrarHospede(String nome, String email, String telefone) {
        return entity.cadastrarHospede(nome, email, telefone);
    }

    public int cadastrarAnfitriao(String nome, String email, String telefone) {
        return entity.cadastrarAnfitriao(nome, email, telefone);
    }

    public boolean solicitarListaDeImoveis(String localizacao, int numHospedes) {
        return entity.recuperarImoveis(localizacao, numHospedes);
    }

    public void solicitarInformacoesDoImovel(int imovelId) {
        entity.recuperarInformacoesDoImovel(imovelId);
    }

    public double getPrecoImovel(int imovelId) {
        return entity.getPrecoImovel(imovelId);
    }

    public void solicitarReserva(int hospedeId, int imovelId, String dataInicio, String dataFim, double valor) {
        entity.criarReserva(hospedeId, imovelId, dataInicio, dataFim, valor);
    }

    public void solicitarPagamento(int reservaId, double valor, String formaPagamento) {
        entity.registrarPagamento(reservaId, valor, formaPagamento);
    }

    public int getUltimaReservaId() {
        return entity.getUltimaReservaId();
    }

    public void solicitarReservaParaAvaliacao(int reservaId) {
        entity.recuperarDetalhesDaReserva(reservaId);
    }

    public void avaliarSolicitacaoDeReserva(int reservaId, boolean aceita) {
        if (aceita) {
            entity.atualizarStatusDaReserva(reservaId, "Aceita");
        } else {
            entity.atualizarStatusDaReserva(reservaId, "Rejeitada");
        }
    }

    public void solicitarCancelamentoReserva(int reservaId, String motivo) {
        entity.cancelarReserva(reservaId, motivo);
    }

    public void solicitarRecursoPorDanos(int reservaId, String descricaoDanos) {
        entity.registrarRecursoPorDanos(reservaId, descricaoDanos);
    }

    public void notificarAnfitriao(int reservaId) {
        entity.notificarAnfitriao(reservaId);
    }

    public void apresentarTodosUsuarios() {
        entity.apresentarTodosUsuarios();
    }

    public int cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco, String localizacao, int numHospedes, String caracteristicas) {
        return entity.cadastrarImovel(anfitriaoId, nome, descricao, preco, localizacao, numHospedes, caracteristicas);
    }

    public boolean exibirReservasHospede(int hospedeId) {
        return entity.exibirReservasHospede(hospedeId);
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        return entity.verificarReservaDoHospede(hospedeId, reservaId);
    }

    public boolean exibirReservasAnfitriao(int anfitriaoId) {
        return entity.exibirReservasAnfitriao(anfitriaoId);
    }

    public boolean exibirImoveisAnfitriao(int anfitriaoId) {
        return entity.exibirImoveisAnfitriao(anfitriaoId);
    }

    public boolean exibirReservasImovel(int imovelId) {
        return entity.exibirReservasImovel(imovelId);
    }

    public boolean verificarDisponibilidade(int imovelId, LocalDate inicio, LocalDate fim) {
        return entity.verificarDisponibilidade(imovelId, inicio, fim);
    }

    public boolean apresentarTodosImoveis() {
        return entity.apresentarTodosImoveis();
    }

    public boolean apresentarTodosHospedes() {
        return entity.apresentarTodosHospedes();
    }

    public boolean apresentarTodosAnfitrioes() {
        return entity.apresentarTodosAnfitrioes();
    }

    public boolean apresentarTodasReservas() {
        return entity.apresentarTodasReservas();
    }

    public double obterValorReserva(int reservaId) {
        return entity.obterValorReserva(reservaId);
    }

    public boolean verificarAprovacaoReserva(int reservaId) {
        return entity.verificarAprovacaoReserva(reservaId);
    }

    public void notificarHospede(int reservaId) {
        entity.notificarHospede(reservaId);
    }

    public boolean exibirReservasPendentesAnfitriao(int anfitriaoId) {
        return entity.exibirReservasPendentesAnfitriao(anfitriaoId);
    }

    public boolean verificarReservaDoAnfitriao(int anfitriaoId, int reservaId) {
        return entity.verificarReservaDoAnfitriao(anfitriaoId, reservaId);
    }

    public Reserva getReserva(int reservaId) {
        return entity.getReserva(reservaId);
    }
}
