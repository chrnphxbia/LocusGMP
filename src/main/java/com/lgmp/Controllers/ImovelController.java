package com.lgmp.Controllers;

import com.lgmp.Entities.Imovel;
import java.util.ArrayList;
import java.util.List;

public class ImovelController {
    public List<Imovel> obterImoveis() {
        // Lógica para recuperar imóveis
        List<Imovel> imoveis = new ArrayList<>();
        Imovel imovel1 = new Imovel();
        imovel1.setId("1");
        imovel1.setDescricao("Apartamento no centro");
        imoveis.add(imovel1);

        Imovel imovel2 = new Imovel();
        imovel2.setId("2");
        imovel2.setDescricao("Casa na praia");
        imoveis.add(imovel2);

        return imoveis;
    }

    public Imovel obterDetalhesImovel(String imovelId) {
        // Lógica para recuperar detalhes do imóvel
        Imovel imovel = new Imovel();
        imovel.setId(imovelId);
        imovel.setDescricao("Descrição do imóvel com ID " + imovelId);
        return imovel;
    }
}
