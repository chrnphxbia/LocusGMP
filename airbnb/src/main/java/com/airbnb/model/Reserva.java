package com.airbnb.model;

public class Reserva {
    private int id;
    private int hospedeId;
    private int imovelId;
    private String dataInicio;
    private String dataFim;
    private String status;
    private double valor;
    private String motivoCancelamento;
    private String descricaoDanos;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", hospedeId=" + hospedeId +
                ", imovelId=" + imovelId +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", status='" + status + '\'' +
                ", valor=" + valor +
                ", motivoCancelamento='" + motivoCancelamento + '\'' +
                ", descricaoDanos='" + descricaoDanos + '\'' +
                '}';
    }
}
