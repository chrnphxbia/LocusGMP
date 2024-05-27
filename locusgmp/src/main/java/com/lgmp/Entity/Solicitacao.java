package com.lgmp.Entity;

public class Solicitacao {
    private int id;
    private Imovel imovel;
    private Hospede hospede;
    private int data;
    private double valor;
    private String status;

    public Solicitacao(int id, Imovel imovel, Hospede hospede, int data, double valor, String status) {
        this.id = id;
        this.imovel = imovel;
        this.hospede = hospede;
        this.data = data;
        this.valor = valor;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Imovel getImovel() { return imovel; }
    public void setImovel(Imovel imovel) { this.imovel = imovel; }

    public Hospede getHospede() { return hospede; }
    public void setHospede(Hospede hospede) { this.hospede = hospede; }

    public int getdata() { return data; }
    public void setdata(int data) { this.data = data; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}