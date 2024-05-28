package com.airbnb;

import com.airbnb.boundary.Boundary;
import com.airbnb.control.Control;
import com.airbnb.entity.Entity;
import com.airbnb.model.Reserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    private static int currentHospedeId = -1;
    private static int currentAnfitriaoId = -1;

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
            System.out.println("3. Criar Usuário (Hóspede/Anfitrião)");
            System.out.println("10. Menu Secreto de Desenvolvedor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    escolherHospede(boundary, scanner);
                    if (currentHospedeId != -1) {
                        interfaceHospede(boundary, scanner);
                    }
                    break;
                case 2:
                    escolherAnfitriao(boundary, scanner);
                    if (currentAnfitriaoId != -1) {
                        interfaceAnfitriao(boundary, scanner);
                    }
                    break;
                case 3:
                    criarUsuario(boundary, scanner);
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

    private static void escolherHospede(Boundary boundary, Scanner scanner) {
        System.out.println("\n=== Escolher Hóspede ===");
        if (!boundary.apresentarTodosHospedes()) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.print("Informe o ID do hóspede: ");
        currentHospedeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    }

    private static void escolherAnfitriao(Boundary boundary, Scanner scanner) {
        System.out.println("\n=== Escolher Anfitrião ===");
        if (!boundary.apresentarTodosAnfitrioes()) {
            System.out.println("Nenhum anfitrião cadastrado.");
            return;
        }

        System.out.print("Informe o ID do anfitrião: ");
        currentAnfitriaoId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    }

    private static void criarUsuario(Boundary boundary, Scanner scanner) {
        System.out.println("\n=== Criar Usuário ===");
        System.out.println("1. Criar Hóspede");
        System.out.println("2. Criar Anfitrião");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                cadastrarHospede(boundary, scanner);
                break;
            case 2:
                cadastrarAnfitriao(boundary, scanner);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void interfaceHospede(Boundary boundary, Scanner scanner) {
        int option;
        do {
            System.out.println("\n=== Interface Hóspede ===");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Minhas Reservas");
            System.out.println("0. Retornar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    realizarReserva(boundary, scanner);
                    break;
                case 2:
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
            System.out.println("1. Cadastrar Imóvel");
            System.out.println("2. Ver Reservas");
            System.out.println("3. Ver Meus Imóveis");
            System.out.println("4. Avaliar Solicitação de Reserva");
            System.out.println("5. Recurso por Dano ao Imóvel");
            System.out.println("0. Retornar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    cadastrarImovel(boundary, scanner);
                    break;
                case 2:
                    verReservasAnfitriao(boundary, scanner);
                    break;
                case 3:
                    verMeusImoveis(boundary, scanner);
                    break;
                case 4:
                    avaliarSolicitacaoDeReserva(boundary, scanner);
                    break;
                case 5:
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
        
        if (!boundary.buscarAnunciosDeReserva(localizacao, numHospedes)) {
            System.out.println("Nenhum imóvel disponível com as características desejadas.");
            return;
        }

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

        double valor = boundary.definirDiasEsolicitarReserva(currentHospedeId, imovelId, dataInicio, dataFim);
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
                    boundary.exibirReservasHospede(currentHospedeId);
                    break;
                case 2:
                    System.out.print("Informe o ID da reserva: ");
                    int reservaId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (boundary.verificarReservaDoHospede(currentHospedeId, reservaId)) {
                        System.out.print("Informe o motivo do cancelamento: ");
                        String motivo = scanner.nextLine();

                        System.out.println("###########POLÍTICA DE CANCELAMENTO###########");
                        System.out.println("Cancelamento gratuito em até 3 dias antes do check-in.");
                        System.out.println();
                        System.out.println("Depois disso, será aplicada uma penalidade ao reembolso com base nas seguintes diretrizes:");
                        System.out.println();
                        System.out.println(" Até 48 horas antes do check-in: Multa de 10%  -  Reembolso de 90%.");
                        System.out.println("Menos de 48 horas antes do check-in: Multa de 50%  -  Reembolso de 50%.");
                        System.out.println("No dia do check-in ou após o check-in: Multa de 100%  -  Sem reembolso.");
                        System.out.println();

                        LocalDate hoje = LocalDate.now();
                        Reserva reserva = boundary.getReserva(reservaId);
                        LocalDate dataCheckin = LocalDate.parse(reserva.getDataInicio());

                        long diasParaCheckin = ChronoUnit.DAYS.between(hoje, dataCheckin);
                        double valorReembolso = 0.0;
                        if (diasParaCheckin > 3) {
                            valorReembolso = reserva.getValor();
                        } else if (diasParaCheckin >= 2) {
                            valorReembolso = reserva.getValor() * 0.9;
                        } else if (diasParaCheckin >= 1) {
                            valorReembolso = reserva.getValor() * 0.5;
                        }

                        System.out.printf("Valor do reembolso: R$%.2f%n", valorReembolso);
                        System.out.print("Deseja realmente cancelar a reserva? (sim/nao): ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("sim")) {
                            boundary.cancelarReserva(reservaId, motivo);
                        } else {
                            System.out.println("Cancelamento de reserva não realizado.");
                        }
                    } else {
                        System.out.println("Você não tem permissão para modificar esta reserva.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o ID da reserva: ");
                    int reservaPagamentoId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (boundary.verificarReservaDoHospede(currentHospedeId, reservaPagamentoId)) {
                        if (boundary.verificarAprovacaoReserva(reservaPagamentoId)) {
                            double valor = boundary.obterValorReserva(reservaPagamentoId);
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

                            boundary.realizarPagamento(reservaPagamentoId, valor, formaPagamento);
                            System.out.println("Pagamento realizado com sucesso! ID da reserva: " + reservaPagamentoId);

                            // Notifica o anfitrião
                            boundary.notificarAnfitriao(reservaPagamentoId);
                        } else {
                            System.out.println("Reserva não aprovada pelo anfitrião.");
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

        int imovelId = boundary.cadastrarImovel(currentAnfitriaoId, nome, descricao, preco, localizacao, numHospedes, caracteristicas);
        System.out.println("Imóvel cadastrado com sucesso! ID do imóvel: " + imovelId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void verReservasAnfitriao(Boundary boundary, Scanner scanner) {
        boundary.exibirReservasAnfitriao(currentAnfitriaoId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void verMeusImoveis(Boundary boundary, Scanner scanner) {
        boundary.exibirImoveisAnfitriao(currentAnfitriaoId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void avaliarSolicitacaoDeReserva(Boundary boundary, Scanner scanner) {
        System.out.println("=== Reservas Pendentes ===");
        if (!boundary.exibirReservasPendentesAnfitriao(currentAnfitriaoId)) {
            System.out.println("Nenhuma reserva pendente encontrada.");
            return;
        }

        System.out.print("Informe o ID da reserva: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (boundary.verificarReservaDoAnfitriao(currentAnfitriaoId, reservaId)) {
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
        System.out.print("Informe o ID da reserva: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (boundary.verificarReservaDoAnfitriao(currentAnfitriaoId, reservaId)) {
            System.out.println("Tipos de dano:");
            System.out.println("1. Estrutural");
            System.out.println("2. Mobiliário");
            System.out.println("3. Limpeza");
            System.out.print("Escolha o tipo de dano: ");
            int tipoDano = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String descricaoDanoTipo;
            switch (tipoDano) {
                case 1:
                    descricaoDanoTipo = "Estrutural";
                    break;
                case 2:
                    descricaoDanoTipo = "Mobiliário";
                    break;
                case 3:
                    descricaoDanoTipo = "Limpeza";
                    break;
                default:
                    System.out.println("Tipo de dano inválido.");
                    return;
            }

            System.out.print("Descreva os danos ao imóvel: ");
            String descricaoDanos = scanner.nextLine();
            boundary.recursoPorDanosAoImovel(reservaId, descricaoDanoTipo + ": " + descricaoDanos);
            
            System.out.println("Enviando email para o hóspede...");
            boundary.notificarHospede(reservaId);

            System.out.println("Email enviado para o hóspede.");

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
