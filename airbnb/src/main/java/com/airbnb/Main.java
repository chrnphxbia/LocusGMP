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
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Minhas Reservas");
            System.out.println("0. Sair");
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
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
        
        scanner.close();
    }

    private static void realizarReserva(Boundary boundary, Scanner scanner) {
        System.out.println("=== Buscar Anúncios de Reserva ===");
        boundary.buscarAnunciosDeReserva();

        System.out.print("Informe o ID do imóvel para reserva: ");
        int imovelId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Informe a data de início (YYYY-MM-DD): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Informe a data de fim (YYYY-MM-DD): ");
        String dataFim = scanner.nextLine();

        double valor = boundary.definirDiasEsolicitarReserva(imovelId, dataInicio, dataFim);
        System.out.println("Valor calculado para a reserva: " + valor);

        int reservaId = 1; // Aqui, assumir que a reservaId é 1 para simplificação. Idealmente, obter o ID gerado da reserva criada.
        boundary.realizarPagamento(reservaId, valor);

        System.out.println("Reserva realizada com sucesso! ID da reserva: " + reservaId);

        // Opção para retornar ao menu principal
        System.out.println("\nPressione Enter para retornar ao menu principal...");
        scanner.nextLine();
    }

    private static void gerenciarReservas(Boundary boundary, Scanner scanner) {
        int subOption;
        do {
            System.out.println("=== Minhas Reservas ===");
            System.out.println("1. Avaliar Solicitação de Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Recurso por Danos ao Imóvel");
            System.out.println("0. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (subOption == 0) {
                break;
            }

            System.out.print("Informe o ID da reserva: ");
            int reservaId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (subOption) {
                case 1:
                    System.out.print("A reserva foi aceita? (true/false): ");
                    boolean aceita = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    boundary.avaliarSolicitacaoDeReserva(reservaId, aceita);
                    break;
                case 2:
                    System.out.print("Informe o motivo do cancelamento: ");
                    String motivo = scanner.nextLine();
                    boundary.cancelarReserva(reservaId, motivo);
                    break;
                case 3:
                    System.out.print("Descreva os danos ao imóvel: ");
                    String descricaoDanos = scanner.nextLine();
                    boundary.recursoPorDanosAoImovel(reservaId, descricaoDanos);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            // Opção para retornar ao menu de reservas
            System.out.println("\nPressione Enter para retornar ao menu de reservas...");
            scanner.nextLine();

        } while (subOption != 0);
    }
}
