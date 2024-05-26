package com.lgmp.Control;

import java.util.ArrayList;

import com.lgmp.Entity.*;

public class ControlCancelamento {
    
    public ArrayList<Imovel> geraListaReservas(Anfitriao anfitriao) {
        ArrayList<Imovel> imoveisReservados = new ArrayList<>();

        for (Imovel imovel : anfitriao.getImoveis()) {
            if(imovel.getStatus() == "Reservado") {
                imoveisReservados.add(imovel);
            }
        }

        return imoveisReservados;
    }

    public void control() {
        
    }

}
