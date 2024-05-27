package com.airbnb.entity;

import com.airbnb.model.Imovel;
import com.airbnb.model.Reserva;
import com.airbnb.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Entity {
    private List<Imovel> imoveis = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Entity() {
        // Inicializa com alguns dados
        imoveis.add(new Imovel(1, "Casa de Praia", "Descrição da casa de praia", 300.0));
        imoveis.add(new Imovel(2, "Apartamento na Cidade", "Descrição do apartamento", 150.0));
    }

    public int cadastrarHospede(String nome) {
        Usuario usuario = new Usuario(usuarios.size() + 1, nome);
        usuarios.add(usuario);
        return usuario.getId();
    }

    public void recuperarImoveis() {
        // Simula a recuperação de imóveis do banco de dados
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }

    public void recuperarInformacoesDoImovel(int imovelId) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == imovelId) {
                System.out.println(imovel);
                break;
            }
        }
    }

    public double getPrecoImovel(int imovelId) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == imovelId) {
                return imovel.getPreco();
            }
        }
        return 0;
    }

    public void criarReserva(int hospedeId, int imovelId, String dataInicio, String dataFim, double valor) {
        Reserva reserva = new Reserva(reservas.size() + 1, hospedeId, imovelId, dataInicio, dataFim, "Pendente");
        reserva.setValor(valor);
        reservas.add(reserva);
        System.out.println("Reserva criada: " + reserva);
    }

    public void registrarPagamento(int reservaId, double valor) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                reserva.setValor(valor);
                reserva.setStatus("Paga");
                System.out.println("Pagamento registrado: " + reserva);
                break;
            }
        }
    }

    public int getUltimaReservaId() {
        if (reservas.isEmpty()) {
            return 0;
        }
        return reservas.get(reservas.size() - 1).getId();
    }

    public void recuperarDetalhesDaReserva(int reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                System.out.println(reserva);
                break;
            }
        }
    }

    public void atualizarStatusDaReserva(int reservaId, String status) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                reserva.setStatus(status);
                System.out.println("Status da reserva atualizado: " + reserva);
                break;
            }
        }
    }

    public void cancelarReserva(int reservaId, String motivo) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                reserva.setStatus("Cancelada");
                reserva.setMotivoCancelamento(motivo);
                System.out.println("Reserva cancelada: " + reserva);
                break;
            }
        }
    }

    public void registrarRecursoPorDanos(int reservaId, String descricaoDanos) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                reserva.setDescricaoDanos(descricaoDanos);
                reserva.setStatus("Recurso por Danos");
                System.out.println("Recurso por danos registrado: " + reserva);
                break;
            }
        }
    }
}