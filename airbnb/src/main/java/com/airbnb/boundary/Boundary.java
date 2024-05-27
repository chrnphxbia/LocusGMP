package com.airbnb.boundary;

import com.airbnb.control.Control;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Boundary {
    private Control control;

    public Boundary(Control control) {
        this.control = control;
    }

    public int cadastrarHospede(String nome, String email, String telefone) {
        return control.cadastrarHospede(nome, email, telefone);
    }

    public int cadastrarAnfitriao(String nome, String email, String telefone) {
        return control.cadastrarAnfitriao(nome, email, telefone);
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

        if (control.verificarDisponibilidade(imovelId, inicio, fim)) {
            control.solicitarReserva(hospedeId, imovelId, dataInicio, dataFim, valor);
            return valor;
        } else {
            return -1; // Indica que a reserva não pode ser feita
        }
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

    public void apresentarTodosUsuarios() {
        control.apresentarTodosUsuarios();
    }

    public int cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco) {
        return control.cadastrarImovel(anfitriaoId, nome, descricao, preco);
    }

    public void exibirReservasHospede(int hospedeId) {
        if (!control.exibirReservasHospede(hospedeId)) {
            System.out.println("Não há informações");
        }
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        return control.verificarReservaDoHospede(hospedeId, reservaId);
    }

    public void exibirReservasAnfitriao(int anfitriaoId) {
        if (!control.exibirReservasAnfitriao(anfitriaoId)) {
            System.out.println("Não há informações");
        }
    }

    public void exibirImoveisAnfitriao(int anfitriaoId) {
        if (!control.exibirImoveisAnfitriao(anfitriaoId)) {
            System.out.println("Não há informações");
        }
    }

    public void exibirReservasImovel(int imovelId) {
        if (!control.exibirReservasImovel(imovelId)) {
            System.out.println("Não há informações");
        }
    }

    public void apresentarTodosImoveis() {
        if (!control.apresentarTodosImoveis()) {
            System.out.println("Não há informações");
        }
    }

    public void apresentarTodosHospedes() {
        if (!control.apresentarTodosHospedes()) {
            System.out.println("Não há informações");
        }
    }

    public void apresentarTodosAnfitrioes() {
        if (!control.apresentarTodosAnfitrioes()) {
            System.out.println("Não há informações");
        }
    }

    public void apresentarTodasReservas() {
        if (!control.apresentarTodasReservas()) {
            System.out.println("Não há informações");
        }
    }
}
