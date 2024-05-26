package com.lgmp.Entity;

import java.util.ArrayList;

public class Hospede extends Usuario {
    private ArrayList<Reserva> reservas;
    
    public Hospede(String nomeDeUsuario, String senha, String nome) {
        super(nomeDeUsuario, "Hospede", senha, nome);
        this.reservas = new ArrayList<>();
    }

    public ArrayList<Reserva> getReservas() { return reservas; }

    public void setReservas(ArrayList<Reserva> reservas) { this.reservas = reservas; }

    public void addReserva(Reserva novaReserva) {
        this.reservas.add(novaReserva);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; Reservas: ");

        for (Reserva reserva : reservas) {
            sb.append(reserva.getID());
            if(reservas.indexOf(reserva) != reservas.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
