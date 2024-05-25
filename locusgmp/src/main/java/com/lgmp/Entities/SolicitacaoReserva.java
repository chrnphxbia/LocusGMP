package com.lgmp.Entities;

public class SolicitacaoReserva {
    private String imovelId;
    private String dataInicio;
    private String dataFim;

    // Getters and Setters
    public String getImovelId() {
        return imovelId;
    }

    public void setImovelId(String imovelId) {
        this.imovelId = imovelId;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
