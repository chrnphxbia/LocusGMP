package com.lgmp.Control;

import java.util.ArrayList;
import java.util.Arrays;

import com.lgmp.Entity.*;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<String> datas = new ArrayList<>(
            Arrays.asList("02/03", "03/03", "04/03")
        );
        Anfitriao anfitriaoteste = new Anfitriao("pedro123", "123", "Pedro");
        Imovel imovelteste = new Imovel("abcd", "Imovel 01", "Reservado", "California", 590.55, 2, anfitriaoteste, datas);
        Hospede hospedeteste = new Hospede("livia123", "321", "Livia");
        Reserva reservateste = new Reserva("XYZ", "Ativa", imovelteste, hospedeteste, 26, 27, 1);
        
        anfitriaoteste.addImovel(imovelteste);
        hospedeteste.addReserva(reservateste);
        
        System.out.println(imovelteste.toString());
        System.out.println(anfitriaoteste.toString());

        System.out.println();

        System.out.println(reservateste.toString());
        System.out.println(hospedeteste.toString());
    }
}
