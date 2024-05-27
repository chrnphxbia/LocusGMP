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
            imoveis.add(new Imovel(1, "Casa de Praia", "Descrição da casa de praia", 300.0, 1, "Praia", 4, "Piscina, Vista para o mar"));
            imoveis.add(new Imovel(2, "Apartamento na Cidade", "Descrição do apartamento", 150.0, 1, "Cidade", 2, "Wi-Fi, Perto do metrô"));
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

    public void recuperarImoveis(String localizacao, int numHospedes) {
        // Simula a recuperação de imóveis do banco de dados com base nos filtros fornecidos
        boolean encontrou = false;
        for (Imovel imovel : imoveis) {
            if ((imovel.getLocalizacao() != null && imovel.getLocalizacao().equalsIgnoreCase(localizacao)) &&
                    imovel.getNumHospedes() >= numHospedes) {
                System.out.println(imovel);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não há informações");
        }
    }

    public void recuperarInformacoesDoImovel(int imovelId) {
        Imovel imovel = getImovelById(imovelId);
        if (imovel == null) {
            System.out.println("Não há informações");
        } else {
            System.out.println(imovel);
        }
    }

    public double getPrecoImovel(int imovelId) {
        Imovel imovel = getImovelById(imovelId);
        return imovel != null ? imovel.getPreco() : 0;
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

    public void registrarPagamento(int reservaId, double valor, String formaPagamento) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva != null) {
            reserva.setValor(valor);
            reserva.setFormaPagamento(formaPagamento);
            reserva.setStatus("Paga");
            salvarDados(reservas, "reservas.dat");
            System.out.println("Pagamento registrado: " + reserva);
        }
    }

    public int getUltimaReservaId() {
        if (reservas.isEmpty()) {
            return 0;
        }
        return reservas.get(reservas.size() - 1).getId();
    }

    public void recuperarDetalhesDaReserva(int reservaId) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva == null) {
            System.out.println("Não há informações");
        } else {
            System.out.println(reserva);
        }
    }

    public void atualizarStatusDaReserva(int reservaId, String status) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva != null) {
            reserva.setStatus(status);
            salvarDados(reservas, "reservas.dat");
            System.out.println("Status da reserva atualizado: " + reserva);
        }
    }

    public void cancelarReserva(int reservaId, String motivo) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva != null) {
            reserva.setStatus("Cancelada");
            reserva.setMotivoCancelamento(motivo);
            salvarDados(reservas, "reservas.dat");
            System.out.println("Reserva cancelada: " + reserva);
        }
    }

    public void registrarRecursoPorDanos(int reservaId, String descricaoDanos) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva != null) {
            reserva.setDescricaoDanos(descricaoDanos);
            reserva.setStatus("Recurso por Danos");
            salvarDados(reservas, "reservas.dat");
            System.out.println("Recurso por danos registrado: " + reserva);
        }
    }

    public void notificarAnfitriao(int reservaId) {
        Reserva reserva = getReservaById(reservaId);
        if (reserva != null) {
            Usuario anfitriao = getAnfitriaoByImovelId(reserva.getImovelId());
            if (anfitriao != null) {
                System.out.println("Notificação enviada para o anfitrião: " + anfitriao.getEmail());
            } else {
                System.out.println("Anfitrião não encontrado para o imóvel da reserva.");
            }
        }
    }

    public void apresentarTodosUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Não há informações");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    public int cadastrarImovel(int anfitriaoId, String nome, String descricao, double preco, String localizacao, int numHospedes, String caracteristicas) {
        int id = imoveis.size() + 1;
        Imovel imovel = new Imovel(id, nome, descricao, preco, anfitriaoId, localizacao, numHospedes, caracteristicas);
        imoveis.add(imovel);
        salvarDados(imoveis, "imoveis.dat");
        return imovel.getId();
    }

    public boolean exibirReservasHospede(int hospedeId) {
        boolean hasReservas = false;
        for (Reserva reserva : reservas) {
            if (reserva.getHospedeId() == hospedeId) {
                System.out.println(reserva);
                hasReservas = true;
            }
        }
        return hasReservas;
    }

    public boolean verificarReservaDoHospede(int hospedeId, int reservaId) {
        Reserva reserva = getReservaById(reservaId);
        return reserva != null && reserva.getHospedeId() == hospedeId;
    }

    public boolean exibirReservasAnfitriao(int anfitriaoId) {
        boolean hasReservas = false;
        for (Reserva reserva : reservas) {
            Imovel imovel = getImovelById(reserva.getImovelId());
            if (imovel != null && imovel.getAnfitriaoId() == anfitriaoId) {
                System.out.println(reserva);
                hasReservas = true;
            }
        }
        return hasReservas;
    }

    public boolean exibirImoveisAnfitriao(int anfitriaoId) {
        boolean hasImoveis = false;
        for (Imovel imovel : imoveis) {
            if (imovel.getAnfitriaoId() == anfitriaoId) {
                System.out.println(imovel);
                hasImoveis = true;
            }
        }
        return hasImoveis;
    }

    public boolean exibirReservasImovel(int imovelId) {
        boolean hasReservas = false;
        for (Reserva reserva : reservas) {
            if (reserva.getImovelId() == imovelId) {
                System.out.println(reserva);
                hasReservas = true;
            }
        }
        return hasReservas;
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

    public boolean apresentarTodosImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Não há informações");
            return false;
        } else {
            for (Imovel imovel : imoveis) {
                System.out.println(imovel);
            }
            return true;
        }
    }

    public boolean apresentarTodosHospedes() {
        if (usuarios.isEmpty()) {
            System.out.println("Não há informações");
            return false;
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
            return true;
        }
    }

    public boolean apresentarTodosAnfitrioes() {
        if (anfitrioes.isEmpty()) {
            System.out.println("Não há informações");
            return false;
        } else {
            for (Usuario usuario : anfitrioes) {
                System.out.println(usuario);
            }
            return true;
        }
    }

    public boolean apresentarTodasReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não há informações");
            return false;
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
            return true;
        }
    }

    private Imovel getImovelById(int imovelId) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == imovelId) {
                return imovel;
            }
        }
        return null;
    }

    private Reserva getReservaById(int reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == reservaId) {
                return reserva;
            }
        }
        return null;
    }

    private Usuario getAnfitriaoByImovelId(int imovelId) {
        Imovel imovel = getImovelById(imovelId);
        if (imovel != null) {
            for (Usuario anfitriao : anfitrioes) {
                if (anfitriao.getId() == imovel.getAnfitriaoId()) {
                    return anfitriao;
                }
            }
        }
        return null;
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
