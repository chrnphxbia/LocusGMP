package Entity;

import java.util.LinkedList;
import java.util.List;

public class Hospedes {
    private List<Hospede> listaHospedes;

    public Hospedes(){
        listaHospedes = new LinkedList<>();
    }

    public void addHospede(Hospede hospede) {listaHospedes.add(hospede);}

    public void removeHospede(Hospede hospede) {listaHospedes.remove(hospede);}
}
