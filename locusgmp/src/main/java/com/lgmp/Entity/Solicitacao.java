package com.lgmp.Entity;

import java.util.Date;

public class Solicitacao {
    private int id;
    private Imovel imovel;
    private Hospede hospede;
    private Date dataInicio;
    private Date dataFim;
    private double valor;
    private String status;

    public Solicitacao(int id, Imovel imovel, Hospede hospede, Date dataInicio, Date dataFim, double valor, String status) {
        this.id = id;
        this.imovel = imovel;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Imovel getImovel() { return imovel; }
    public void setImovel(Imovel imovel) { this.imovel = imovel; }

    public Hospede getHospede() { return hospede; }
    public void setHospede(Hospede hospede) { this.hospede = hospede; }

    public Date getDataInicio() { return dataInicio; }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim; }
    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
