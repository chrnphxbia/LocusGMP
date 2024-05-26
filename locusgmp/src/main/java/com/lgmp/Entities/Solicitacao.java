package com.lgmp.Entities;

public class Solicitacao {
    private String id;
    //private Reserva reserva;
    private String descricao;
    private float valor;

    public Solicitacao(String id, /*Reserva reserva,*/ String descricao, float valor) {
        this.id = id;
        //this.reserva = reserva;
        this.descricao = descricao;
        this.valorCompensacao = valor;
    }

    public String getId() { return id; }
    //public Imovel getReserva() { return reserva; }
    public String getDescricao() { return descricao; }
    public float getValor() { return valor; }

    public void setID(String id) { this.id = id; } 
    public void setDescricao(String descricao) {this.descricao = descricao; }
    public void setValor(String valor) { this.valor = valor; }  
}