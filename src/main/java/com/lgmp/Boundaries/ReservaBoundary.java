package com.lgmp.Boundaries;

import com.lgmp.Controllers.ReservaController;
import com.lgmp.Entities.SolicitacaoReserva;
import com.lgmp.Entities.RespostaReserva;

public class ReservaBoundary {
    private ReservaController reservaController = new ReservaController();

    public RespostaReserva solicitarReserva(SolicitacaoReserva solicitacao) {
        return reservaController.criarReserva(solicitacao);
    }

    public RespostaReserva processarPagamento(String reservaId) {
        return reservaController.realizarPagamento(reservaId);
    }
}
