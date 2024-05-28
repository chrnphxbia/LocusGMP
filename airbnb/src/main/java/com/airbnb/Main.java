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
            System.out.println("=== Menu Inicial ===");
            System.out.println("1. Interface Hóspede");
            System.out.println("2. Interface Anfitrião");
            System.out.println("10. Menu Secreto de Desenvolvedor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    interfaceHospede(boundary, scanner);
                    break;
                case 2:
                    interfaceAnfitriao(boundary, scanner);
                    break;
                case 10:
                    menuSecretoDev(boundary, scanner);
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

    private static void interfaceHospede(Boundary boundary, Scanner scanner) {
        int option;
        do {
            System.out.println("\n=== Interface Hóspede ===");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Realizar Reserva");
            System.out.println("3. Minhas Reservas");
            System.out.println("0. Retornar ao Menu Inicial");
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
                case 0:
                    System.out.println("Retornando ao menu inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    private static void interfaceAnfitriao(Boundary boundary, Scanner scanner) {
        int option;
        do {
            System.out.println("\n=== Interface Anfitrião ===");
            System.out.println("1. Cadastrar Anfitrião");
            System.out.println("2. Cadastrar Imóvel");
            System.out.println("3. Ver Reservas");
            System.out.println("4. Ver Meus Imóveis");
            System.out.println("5. Avaliar Solicitação de Reserva");
            System.out.println("6. Recurso por Dano ao Imóvel");
            System.out.println("0. Retornar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    cadastrarAnfitriao(boundary, scanner);
                    break;
                case 2:
                    cadastrarImovel(boundary, scanner);
                    break;
                case 3:
                    verReservasAnfitriao(boundary, scanner);
                    break;
                case 4:
                    verMeusImoveis(boundary, scanner);
                    break;
                case 5:
                    avaliarSolicitacaoDeReserva(boundary, scanner);
                    break;
                case 6:
                    recursoPorDanoAoImovel(boundary, scanner);
                    break;
                case 0:
                    System.out.println("Retornando ao menu inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
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

    private static void cadastrarAnfitriao(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o nome do anfitrião: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o email do anfitrião: ");
        String email = scanner.nextLine();

        System.out.print("Informe o telefone do anfitrião: ");
        String telefone = scanner.nextLine();

        int anfitriaoId = boundary.cadastrarAnfitriao(nome, email, telefone);
        System.out.println("Anfitrião cadastrado com sucesso! ID do anfitrião: " + anfitriaoId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void realizarReserva(Boundary boundary, Scanner scanner) {
        System.out.println("\n=== Buscar Anúncios de Reserva ===");
        
        // Solicita filtros de busca
        System.out.print("Informe a localização desejada (Praia/Cidade): ");
        String localizacao = scanner.nextLine();
        
        System.out.print("Informe o número de hóspedes: ");
        int numHospedes = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        boundary.buscarAnunciosDeReserva(localizacao, numHospedes);

        System.out.print("Informe o ID do hóspede: ");
        int hospedeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe o ID do imóvel para reserva: ");
        int imovelId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Exibe informações do imóvel selecionado
        boundary.selecionarAnuncioParaReserva(imovelId);

        // Pergunta ao usuário se tem alguma dúvida
        System.out.print("Você tem alguma pergunta sobre o imóvel? (sim/nao): ");
        String pergunta = scanner.nextLine();
        if (pergunta.equalsIgnoreCase("sim")) {
            System.out.print("Digite sua pergunta: ");
            String questao = scanner.nextLine();
            boundary.processarPergunta(questao);
        }

        // Verifica se o usuário deseja prosseguir com a reserva
        System.out.print("Deseja prosseguir com a reserva? (sim/nao): ");
        String prosseguir = scanner.nextLine();
        if (!prosseguir.equalsIgnoreCase("sim")) {
            System.out.println("Reserva cancelada.");
            return;
        }

        System.out.print("Informe a data de início (YYYY-MM-DD): ");
        String dataInicio = scanner.nextLine();

        System.out.print("Informe a data de fim (YYYY-MM-DD): ");
        String dataFim = scanner.nextLine();

        double valor = boundary.definirDiasEsolicitarReserva(hospedeId, imovelId, dataInicio, dataFim);
        if (valor == -1) {
            System.out.println("Não é possível realizar a reserva para o período informado.");
        } else {
            System.out.println("Reserva realizada com sucesso! Valor calculado: " + valor);
        }

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
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Realizar Pagamento de Reserva");
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
                    System.out.print("Informe o ID da reserva: ");
                    int reservaId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (boundary.verificarReservaDoHospede(hospedeId, reservaId)) {
                        if (subOption == 2) {
                            System.out.print("Informe o motivo do cancelamento: ");
                            String motivo = scanner.nextLine();
                            boundary.cancelarReserva(reservaId, motivo);
                        } else if (subOption == 3) {
                            double valor = boundary.obterValorReserva(reservaId);
                            System.out.println("Valor da reserva: " + valor);

                            System.out.println("Escolha a forma de pagamento:");
                            System.out.println("1. Crédito");
                            System.out.println("2. Débito");
                            System.out.println("3. Pix");
                            System.out.print("Escolha uma opção: ");
                            int pagamentoOption = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            String formaPagamento;
                            switch (pagamentoOption) {
                                case 1:
                                    formaPagamento = "Crédito";
                                    break;
                                case 2:
                                    formaPagamento = "Débito";
                                    break;
                                case 3:
                                    formaPagamento = "Pix";
                                    break;
                                default:
                                    System.out.println("Opção inválida. Pagamento cancelado.");
                                    return;
                            }

                            boundary.realizarPagamento(reservaId, valor, formaPagamento);
                            System.out.println("Pagamento realizado com sucesso! ID da reserva: " + reservaId);

                            // Notifica o anfitrião
                            boundary.notificarAnfitriao(reservaId);
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

    private static void cadastrarImovel(Boundary boundary, Scanner scanner) {
        System.out.print("Informe o ID do anfitrião: ");
        int anfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("\nInforme o nome do imóvel: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a descrição do imóvel: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o preço do imóvel: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe a localização do imóvel: ");
        String localizacao = scanner.nextLine();

        System.out.print("Informe o número de hóspedes que o imóvel acomoda: ");
        int numHospedes = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe as características do imóvel: ");
        String caracteristicas = scanner.nextLine();

        int imovelId = boundary.cadastrarImovel(anfitriaoId, nome, descricao, preco, localizacao, numHospedes, caracteristicas);
        System.out.println("Imóvel cadastrado com sucesso! ID do imóvel: " + imovelId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void verReservasAnfitriao(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o ID do anfitrião: ");
        int anfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boundary.exibirReservasAnfitriao(anfitriaoId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void verMeusImoveis(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o ID do anfitrião: ");
        int anfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boundary.exibirImoveisAnfitriao(anfitriaoId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void avaliarSolicitacaoDeReserva(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o ID do anfitrião: ");
        int anfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe o ID da reserva: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (boundary.verificarReservaDoHospede(anfitriaoId, reservaId)) {
            System.out.print("A reserva foi aceita? (true/false): ");
            boolean aceita = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline
            boundary.avaliarSolicitacaoDeReserva(reservaId, aceita);
        } else {
            System.out.println("Você não tem permissão para avaliar esta reserva.");
        }

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void recursoPorDanoAoImovel(Boundary boundary, Scanner scanner) {
        System.out.print("\nInforme o ID do anfitrião: ");
        int anfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe o ID da reserva: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (boundary.verificarReservaDoHospede(anfitriaoId, reservaId)) {
            System.out.print("Descreva os danos ao imóvel: ");
            String descricaoDanos = scanner.nextLine();
            boundary.recursoPorDanosAoImovel(reservaId, descricaoDanos);
        } else {
            System.out.println("Você não tem permissão para registrar recurso por danos nesta reserva.");
        }

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void menuSecretoDev(Boundary boundary, Scanner scanner) {
        int option;
        do {
            System.out.println("\n=== Menu Secreto de Desenvolvedor ===");
            System.out.println("1. Apresentar Todos os Imóveis Cadastrados");
            System.out.println("2. Apresentar Todos os Hóspedes Cadastrados");
            System.out.println("3. Apresentar Todos os Anfitriões Cadastrados");
            System.out.println("4. Apresentar Todas as Reservas");
            System.out.println("0. Retornar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    boundary.apresentarTodosImoveis();
                    break;
                case 2:
                    boundary.apresentarTodosHospedes();
                    break;
                case 3:
                    boundary.apresentarTodosAnfitrioes();
                    break;
                case 4:
                    boundary.apresentarTodasReservas();
                    break;
                case 0:
                    System.out.println("Retornando ao menu inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // Opção para retornar ao menu secreto de desenvolvedor
            if (option != 0) {
                System.out.println("\nPressione Enter para retornar ao menu secreto de desenvolvedor...");
                scanner.nextLine();
            }

        } while (option != 0);
    }
}
