package com.airbnb.boundary;

import com.airbnb.control.Control;
import com.airbnb.model.Reserva;

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

    public boolean buscarAnunciosDeReserva(String localizacao, int numHospedes) {
        return control.solicitarListaDeImoveis(localizacao, numHospedes);
    }

    public void selecionarAnuncioParaReserva(int imovelId) {
        control.solicitarInformacoesDoImovel(imovelId);
    }

    public void processarPergunta(String pergunta) {
        System.out.println("Processando pergunta: " + pergunta);
        // Aqui você pode adicionar lógica adicional para tratar a pergunta
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

    public void realizarPagamento(int reservaId, double valor, String formaPagamento) {
        control.solicitarPagamento(reservaId, valor, formaPagamento);
    }

    public int getUltimaReservaId() {
        return control.getUltimaReservaId();
    }

    public void selecionarReservaParaAvaliacao(int reservaId) {
        control.solicitarReservaParaAvaliacao(reservaId);
    }

    public void avaliarSolicitacaoDeReserva(int reservaId, boolean aceita) {
        control.avaliarSolicitacaoDeReserva(reservaId, aceita);
    }

    public void cancelarReserva(int reservaId, String motivo) {
        control.solicitarCancelamentoReserva(reservaId, motivo);
    }

    public void recursoPorDanosAoImovel(int reservaId, String descricaoDanos) {
        control.solicitarRecursoPorDanos(reservaId, descricaoDanos);
    }

    public void notificarAnfitriao(int reservaId) {
        control.notificarAnfitriao(reservaId);
    }

    public void apresentarTodosUsuarios() {
        control.apresentarTodosUsuarios();
    }

    public int cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco, String localizacao, int numHospedes, String caracteristicas) {
        return control.cadastrarImovel(anfitriaoId, nome, descricao, preco, localizacao, numHospedes, caracteristicas);
    }

    public boolean exibirReservasHospede(int hospedeId) {
        return control.exibirReservasHospede(hospedeId);
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        return control.verificarReservaDoHospede(hospedeId, reservaId);
    }

    public boolean exibirReservasAnfitriao(int anfitriaoId) {
        return control.exibirReservasAnfitriao(anfitriaoId);
    }

    public boolean exibirImoveisAnfitriao(int anfitriaoId) {
        return control.exibirImoveisAnfitriao(anfitriaoId);
    }

    public boolean exibirReservasImovel(int imovelId) {
        return control.exibirReservasImovel(imovelId);
    }

    public boolean apresentarTodosImoveis() {
        return control.apresentarTodosImoveis();
    }

    public boolean apresentarTodosHospedes() {
        return control.apresentarTodosHospedes();
    }

    public boolean apresentarTodosAnfitrioes() {
        return control.apresentarTodosAnfitrioes();
    }

    public boolean apresentarTodasReservas() {
        return control.apresentarTodasReservas();
    }

    public double obterValorReserva(int reservaId) {
        return control.obterValorReserva(reservaId);
    }

    public boolean verificarAprovacaoReserva(int reservaId) {
        return control.verificarAprovacaoReserva(reservaId);
    }

    public void notificarHospede(int reservaId) {
        control.notificarHospede(reservaId);
    }

    public boolean exibirReservasPendentesAnfitriao(int anfitriaoId) {
        return control.exibirReservasPendentesAnfitriao(anfitriaoId);
    }

    public boolean verificarReservaDoAnfitriao(int anfitriaoId, int reservaId) {
        return control.verificarReservaDoAnfitriao(anfitriaoId, reservaId);
    }

    public Reserva getReserva(int reservaId) {
        return control.getReserva(reservaId);
    }
}
