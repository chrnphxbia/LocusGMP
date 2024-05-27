package com.airbnb.control;

import com.airbnb.entity.Entity;

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

    public void solicitarListaDeImoveis() {
        entity.recuperarImoveis();
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

    public void solicitarPagamento(int reservaId, double valor) {
        entity.registrarPagamento(reservaId, valor);
    }

    public int getUltimaReservaId() {
        return entity.getUltimaReservaId();
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

    public void apresentarTodosUsuarios() {
        entity.apresentarTodosUsuarios();
    }

    public void cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco) {
        entity.cadastrarImovel(anfitriaoId, nome, descricao, preco);
    }

    public void exibirReservasHospede(int hospedeId) {
        entity.exibirReservasHospede(hospedeId);
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        return entity.verificarReservaDoHospede(hospedeId, reservaId);
    }

    public void exibirReservasImovel(int imovelId) {
        entity.exibirReservasImovel(imovelId);
    }

    public boolean verificarDisponibilidade(int imovelId, LocalDate inicio, LocalDate fim) {
        return entity.verificarDisponibilidade(imovelId, inicio, fim);
    }

    public void apresentarTodosImoveis() {
        entity.apresentarTodosImoveis();
    }

    public void apresentarTodosHospedes() {
        entity.apresentarTodosHospedes();
    }

    public void apresentarTodosAnfitrioes() {
        entity.apresentarTodosAnfitrioes();
    }

    public void apresentarTodasReservas() {
        entity.apresentarTodasReservas();
    }
}
