package com.lgmp.Boundaries;

import com.lgmp.Controllers.AnfitriaoController;
import com.lgmp.Entities.Anfitriao;
import java.util.List;

public class AnfitriaoBoundary {
    private AnfitriaoController anfitriaoController = new AnfitriaoController();

    public List<Anfitriao> listarAnfitrioes() {
        return anfitriaoController.obterAnfitrioes();
    }

    public Anfitriao verDetalhesAnfitriao(String anfitriaoId) {
        return anfitriaoController.obterDetalhesAnfitriao(anfitriaoId);
    }
}
