package com.airbnb;

import com.airbnb.boundary.Boundary;
import com.airbnb.control.Control;
import com.airbnb.entity.Entity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializando as camadas do sistema
        Entity entity = new Entity();
        Control control = new Control(entity);
        Boundary boundary = new Boundary(control);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Realizar Reserva");
            System.out.println("3. Minhas Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    cadastrarHospede(boundary, scanner);
                    break;
                case 2:
                    realizarReserva(boundary, scanner);
                    break;
                case 3:
                    gerenciarReservas(boundary, scanner);
                    break;
                case 10:
                    menuOpcaoOculta(boundary, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void cadastrarHospede(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o email do hóspede: ");
        String email = scanner.nextLine();

        System.out.print("Informe o telefone do hóspede: ");
        String telefone = scanner.nextLine();

        int hospedeId = boundary.cadastrarHospede(nome, email, telefone);
        System.out.println("Hóspede cadastrado com sucesso! ID do hóspede: " + hospedeId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void realizarReserva(Boundary boundary, Scanner scanner) {
        System.out.println("\n=== Buscar Anúncios de Reserva ===");
        boundary.buscarAnunciosDeReserva();

        System.out.print("Informe o ID do hóspede: ");
        int hospedeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe o ID do imóvel para reserva: ");
        int imovelId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe a data de início (YYYY-MM-DD): ");
        String dataInicio = scanner.nextLine();

        System.out.print("Informe a data de fim (YYYY-MM-DD): ");
        String dataFim = scanner.nextLine();

        double valor = boundary.definirDiasEsolicitarReserva(hospedeId, imovelId, dataInicio, dataFim);
        System.out.println("Valor calculado para a reserva: " + valor);

        int reservaId = boundary.getUltimaReservaId();
        boundary.realizarPagamento(reservaId, valor);
        System.out.println("Reserva realizada com sucesso! ID da reserva: " + reservaId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void gerenciarReservas(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o ID do hóspede: ");
        int hospedeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int subOption;
        do {
            System.out.println("\n=== Minhas Reservas ===");
            System.out.println("1. Exibir Todas as Reservas");
            System.out.println("2. Avaliar Solicitação de Reserva");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Recurso por Danos ao Imóvel");
            System.out.println("0. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (subOption == 0) {
                break;
            }

            switch (subOption) {
                case 1:
                    boundary.exibirReservasHospede(hospedeId);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.print("Informe o ID da reserva: ");
                    int reservaId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (boundary.verificarReservaDoHospede(hospedeId, reservaId)) {
                        if (subOption == 2) {
                            System.out.print("A reserva foi aceita? (true/false): ");
                            boolean aceita = scanner.nextBoolean();
                            scanner.nextLine(); // Consume newline
                            boundary.avaliarSolicitacaoDeReserva(reservaId, aceita);
                        } else if (subOption == 3) {
                            System.out.print("Informe o motivo do cancelamento: ");
                            String motivo = scanner.nextLine();
                            boundary.cancelarReserva(reservaId, motivo);
                        } else if (subOption == 4) {
                            System.out.print("Descreva os danos ao imóvel: ");
                            String descricaoDanos = scanner.nextLine();
                            boundary.recursoPorDanosAoImovel(reservaId, descricaoDanos);
                        }
                    } else {
                        System.out.println("Você não tem permissão para modificar esta reserva.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            // Opção para retornar ao menu de reservas
            System.out.println("\nPressione Enter para retornar ao menu de reservas...");
            scanner.nextLine();

        } while (subOption != 0);
    }

    private static void menuOpcaoOculta(Boundary boundary, Scanner scanner) {
        int subOption;
        do {
            System.out.println("\n=== Menu Oculto ===");
            System.out.println("1. Apresentar Todos os Usuários Cadastrados");
            System.out.println("2. Exibir Imóveis");
            System.out.println("3. Cadastrar Imóvel");
            System.out.println("0. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (subOption == 0) {
                break;
            }

            switch (subOption) {
                case 1:
                    boundary.apresentarTodosUsuarios();
                    break;
                case 2:
                    boundary.buscarAnunciosDeReserva();
                    break;
                case 3:
                    System.out.print("\nInforme o nome do imóvel: ");
                    String nome = scanner.nextLine();

                    System.out.print("Informe a descrição do imóvel: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Informe o preço do imóvel: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    boundary.cadastrarImovel(nome, descricao, preco);
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            // Opção para retornar ao menu oculto
            System.out.println("\nPressione Enter para retornar ao menu oculto...");
            scanner.nextLine();

        } while (subOption != 0);
    }
}
