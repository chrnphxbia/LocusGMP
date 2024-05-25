package Control;

import java.util.List;

import Entity.*;

public class ReservasControl {
    public static List<Reserva> recuperaReservas(Hospede hospede){
       List<Reserva> lista = hospede.getListaReservas();
        


       return lista;
    }
}




//Control: recuperar dados