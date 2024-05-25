package com.lgmp.Controllers;

import com.lgmp.Entities.Hospede;
import java.util.ArrayList;
import java.util.List;

public class HospedeController {
    public List<Hospede> obterHospedes() {
        // Lógica para recuperar hóspedes
        List<Hospede> hospedes = new ArrayList<>();
        Hospede hospede1 = new Hospede();
        hospede1.setId("1");
        hospede1.setNome("João");
        hospedes.add(hospede1);

        Hospede hospede2 = new Hospede();
        hospede2.setId("2");
        hospede2.setNome("Maria");
        hospedes.add(hospede2);

        return hospedes;
    }

    public Hospede obterDetalhesHospede(String hospedeId) {
        // Lógica para recuperar detalhes do hóspede
        Hospede hospede = new Hospede();
        hospede.setId(hospedeId);
        hospede.setNome("Nome do hóspede com ID " + hospedeId);
        return hospede;
    }
}
