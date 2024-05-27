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
        boundary.buscarAnunciosDeReserva();
        boundary.selecionarAnuncioParaReserva(1);
        boundary.definirDiasEsolicitarReserva(1, "2024-06-01", "2024-06-10");
        boundary.realizarPagamento(1, 500.0);
        
        boundary.selecionarReservaParaAvaliacao(1);
        boundary.avaliarSolicitacaoDeReserva(1, true);
        
        boundary.cancelarReserva(1, "Change of plans");
        
        boundary.recursoPorDanosAoImovel(1, "Broken window");
    }
}
