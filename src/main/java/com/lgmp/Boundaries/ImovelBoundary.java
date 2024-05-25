package com.lgmp.Boundaries;

import com.lgmp.Controllers.ImovelController;
import com.lgmp.Entities.Imovel;
import java.util.List;

public class ImovelBoundary {
    private ImovelController imovelController = new ImovelController();

    public List<Imovel> listarImoveis() {
        return imovelController.obterImoveis();
    }

    public Imovel verDetalhesImovel(String imovelId) {
        return imovelController.obterDetalhesImovel(imovelId);
    }
}
