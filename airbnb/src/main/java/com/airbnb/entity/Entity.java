package com.airbnb.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airbnb.model.Imovel;
import com.airbnb.model.Reserva;
import com.airbnb.model.Usuario;

public class Entity {
    private List<Imovel> imoveis;
    private List<Reserva> reservas;
    private List<Usuario> usuarios;
    private List<Usuario> anfitrioes;

    public Entity() {
        this.imoveis = carregarDados("imoveis.dat");
        this.reservas = carregarDados("reservas.dat");
        this.usuarios = carregarDados("usuarios.dat");
        this.anfitrioes = carregarDados("anfitrioes.dat");

        // Se os arquivos não existirem, inicializar com alguns dados
        if (imoveis.isEmpty()) {
            imoveis.add(new Imovel(1, "Casa de Praia", "Descrição da casa de praia", 300.0, 1));
            imoveis.add(new Imovel(2, "Apartamento na Cidade", "Descrição do apartamento", 150.0, 1));
            salvarDados(imoveis, "imoveis.dat");
        }
    }

    public int cadastrarHospede(String nome, String email, String telefone) {
        int id = usuarios.size() + 1;
        Usuario usuario = new Usuario(id, nome, email, telefone);
        usuarios.add(usuario);
        salvarDados(usuarios, "usuarios.dat");
        return usuario.getId();
    }

    public int cadastrarAnfitriao(String nome, String email, String telefone) {
        int id = anfitrioes.size() + 1;
        Usuario usuario = new Usuario(id, nome, email, telefone);
        anfitrioes.add(usuario);
        salvarDados(anfitrioes, "anfitrioes.dat");
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
        int id = reservas.size() + 1;
        Reserva reserva = new Reserva(id, hospedeId, imovelId, dataInicio, dataFim, "Pendente");
        reserva.setValor(valor);
        reservas.add(reserva);

        // Associar a reserva ao hóspede
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == hospedeId) {
                usuario.adicionarReserva(id);
                break;
            }
        }
        
        salvarDados(reservas, "reservas.dat");
        salvarDados(usuarios, "usuarios.dat");
        System.out.println("Reserva criada: " + reserva);
    }

    public void registrarPagamento(int reservaId, double valor) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                reserva.setValor(valor);
                reserva.setStatus("Paga");
                salvarDados(reservas, "reservas.dat");
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
                salvarDados(reservas, "reservas.dat");
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
                salvarDados(reservas, "reservas.dat");
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
                salvarDados(reservas, "reservas.dat");
                System.out.println("Recurso por danos registrado: " + reserva);
                break;
            }
        }
    }

    public void apresentarTodosUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco) {
        int id = imoveis.size() + 1;
        Imovel imovel = new Imovel(id, nome, descricao, preco, anfitriaoId);
        imoveis.add(imovel);
        salvarDados(imoveis, "imoveis.dat");
    }

    public void exibirReservasHospede(int hospedeId) {
        for (Reserva reserva : reservas) {
            if (reserva.getHospedeId() == hospedeId) {
                System.out.println(reserva);
            }
        }
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId && reserva.getHospedeId() == hospedeId) {
                return true;
            }
        }
        return false;
    }

    public void exibirReservasImovel(int imovelId) {
        for (Reserva reserva : reservas) {
            if (reserva.getImovelId() == imovelId) {
                System.out.println(reserva);
            }
        }
    }

    public boolean verificarDisponibilidade(int imovelId, LocalDate inicio, LocalDate fim) {
        for (Reserva reserva : reservas) {
            if (reserva.getImovelId() == imovelId && !reserva.getStatus().equals("Cancelada")) {
                LocalDate reservaInicio = LocalDate.parse(reserva.getDataInicio());
                LocalDate reservaFim = LocalDate.parse(reserva.getDataFim());

                if ((inicio.isBefore(reservaFim) && inicio.isAfter(reservaInicio)) ||
                        (fim.isBefore(reservaFim) && fim.isAfter(reservaInicio)) ||
                        (inicio.isEqual(reservaInicio) || fim.isEqual(reservaFim) || 
                        (inicio.isBefore(reservaInicio) && fim.isAfter(reservaFim)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void apresentarTodosImoveis() {
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }

    public void apresentarTodosHospedes() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void apresentarTodosAnfitrioes() {
        for (Usuario usuario : anfitrioes) {
            System.out.println(usuario);
        }
    }

    public void apresentarTodasReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> carregarDados(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private <T> void salvarDados(List<T> dados, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
