package com.lgmp.Boundary;

import java.util.ArrayList;

import com.lgmp.Entity.*;

public class CancelamentoBoundary extends BoundaryGeral{
    
    public void exibeImoveisReservados(ArrayList<Imovel> imoveisReservados) {
        for (Imovel imovel : imoveisReservados) {
            System.out.println(imovel.toString() + "\n");
        }
    }

}
