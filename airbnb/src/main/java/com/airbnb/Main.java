package com.airbnb;

import com.airbnb.boundary.Boundary;
import com.airbnb.control.Control;
import com.airbnb.entity.Entity;

public class Main {
    public static void main(String[] args) {
        // Inicializando as camadas do sistema
        Entity entity = new Entity();
        Control control = new Control(entity);
        Boundary boundary = new Boundary(control);
        
        // Chamadas de exemplo
        System.out.println("=== Busca de Anúncios de Reserva ===");
        boundary.buscarAnunciosDeReserva();
        
        System.out.println("\n=== Seleção de Anúncio para Reserva ===");
        boundary.selecionarAnuncioParaReserva(1);
        
        System.out.println("\n=== Definição de Dias e Solicitação de Reserva ===");
        boundary.definirDiasEsolicitarReserva(1, "2024-06-01", "2024-06-10");
        
        System.out.println("\n=== Realização de Pagamento ===");
        boundary.realizarPagamento(1, 500.0);
        
        System.out.println("\n=== Seleção de Reserva para Avaliação ===");
        boundary.selecionarReservaParaAvaliacao(1);
        
        System.out.println("\n=== Avaliação de Solicitação de Reserva ===");
        boundary.avaliarSolicitacaoDeReserva(1, true);
        
        System.out.println("\n=== Cancelamento de Reserva ===");
        boundary.cancelarReserva(1, "Change of plans");
        
        System.out.println("\n=== Recurso por Danos ao Imóvel ===");
        boundary.recursoPorDanosAoImovel(1, "Broken window");
    }
}
