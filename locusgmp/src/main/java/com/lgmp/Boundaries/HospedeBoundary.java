package com.lgmp.Boundaries;

import com.lgmp.Controllers.HospedeController;
import com.lgmp.Entities.Hospede;
import java.util.List;

public class HospedeBoundary {
    private HospedeController hospedeController = new HospedeController();

    public List<Hospede> listarHospedes() {
        return hospedeController.obterHospedes();
    }

    public Hospede verDetalhesHospede(String hospedeId) {
        return hospedeController.obterDetalhesHospede(hospedeId);
    }
}
