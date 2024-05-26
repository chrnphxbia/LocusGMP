package com.lgmp.Entity;

public class Reserva {

    private String id;
    private String status;
    private Imovel imovelReservado;
    private Hospede hospedeDaReserva;
    private int checkIn;
    private int checkOut;
    private double valor;
    private int numeroHospedes;

    public Reserva(String id, String status, Imovel imovelReservado, Hospede hospedeDaReserva,
    int checkIn, int checkOut, int numeroHospedes) {
        this.id = id;
        this.status = status;
        this.imovelReservado = imovelReservado;
        this.hospedeDaReserva = hospedeDaReserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.valor = imovelReservado.getValorDiaria() * (checkOut - checkIn);
        this.numeroHospedes = numeroHospedes;
    }

    public String getID() { return this.id; }
    public String getStatus() { return this.status; }
    public Imovel getImovel() { return this.imovelReservado; }
    public Hospede getHospede() { return this.hospedeDaReserva; }
    public int getCheckIn() { return this.checkIn; }
    public int getCheckOut() { return this.checkOut; }
    public double getValor() { return this.valor; }
    public int getNumeroHospedes() { return this.numeroHospedes; }

    public void setID(String id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
    public void setImovel(Imovel imovel) { this.imovelReservado = imovel; }
    public void setHospede(Hospede hospede) { this.hospedeDaReserva = hospede; }
    public void setCheckIn(int checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(int checkOut) { this.checkOut = checkOut; }
    public void setValor(double valor) { this.valor = valor; }
    public void setNumeroHospedes(int numeroHospedes) { this.numeroHospedes = numeroHospedes; }

    @Override
    public String toString() {
        return "ID: " + id + "; Status: " + status + "; Imovel: " + imovelReservado.getID() +
        "; Hospede: " + hospedeDaReserva.getNome() + "; Check-In: " + checkIn + "; Check-Out: " +
        checkOut + "; Valor: " + valor + "; Num. Hospedes: " + numeroHospedes;
    }
}
