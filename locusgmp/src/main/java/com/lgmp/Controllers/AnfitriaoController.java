package com.lgmp.Controllers;

import com.lgmp.Entities.Anfitriao;
import java.util.ArrayList;
import java.util.List;

public class AnfitriaoController {
    public List<Anfitriao> obterAnfitrioes() {
        // Lógica para recuperar anfitriões
        List<Anfitriao> anfitrioes = new ArrayList<>();
        Anfitriao anfitriao1 = new Anfitriao();
        anfitriao1.setId("1");
        anfitriao1.setNome("Carlos");
        anfitrioes.add(anfitriao1);

        Anfitriao anfitriao2 = new Anfitriao();
        anfitriao2.setId("2");
        anfitriao2.setNome("Ana");
        anfitrioes.add(anfitriao2);

        return anfitrioes;
    }

    public Anfitriao obterDetalhesAnfitriao(String anfitriaoId) {
        // Lógica para recuperar detalhes do anfitrião
        Anfitriao anfitriao = new Anfitriao();
        anfitriao.setId(anfitriaoId);
        anfitriao.setNome("Nome do anfitrião com ID " + anfitriaoId);
        return anfitriao;
    }
}
