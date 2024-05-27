package com.airbnb.model;

import java.io.Serializable;

public class Reserva implements Serializable {
    private int id;
    private int hospedeId;
    private int imovelId;
    private String dataInicio;
    private String dataFim;
    private double valor;
    private String status;
    private String motivoCancelamento;
    private String descricaoDanos;
    private String formaPagamento;

    public Reserva(int id, int hospedeId, int imovelId, String dataInicio, String dataFim, String status) {
        this.id = id;
        this.hospedeId = hospedeId;
        this.imovelId = imovelId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public int getImovelId() {
        return imovelId;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getDescricaoDanos() {
        return descricaoDanos;
    }

    public void setDescricaoDanos(String descricaoDanos) {
        this.descricaoDanos = descricaoDanos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", hospedeId=" + hospedeId +
                ", imovelId=" + imovelId +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                ", motivoCancelamento='" + motivoCancelamento + '\'' +
                ", descricaoDanos='" + descricaoDanos + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
