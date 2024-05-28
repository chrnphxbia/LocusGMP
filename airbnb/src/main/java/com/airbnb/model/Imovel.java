package com.airbnb.model;

import java.io.Serializable;

public class Imovel implements Serializable {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int anfitriaoId;
    private String localizacao;
    private int numHospedes;
    private String caracteristicas;

    public Imovel(int id, String nome, String descricao, double preco, int anfitriaoId, String localizacao, int numHospedes, String caracteristicas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.anfitriaoId = anfitriaoId;
        this.localizacao = localizacao;
        this.numHospedes = numHospedes;
        this.caracteristicas = caracteristicas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getAnfitriaoId() {
        return anfitriaoId;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNumHospedes() {
        return numHospedes;
    }

    public void setNumHospedes(int numHospedes) {
        this.numHospedes = numHospedes;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", anfitriaoId=" + anfitriaoId +
                ", localizacao='" + localizacao + '\'' +
                ", numHospedes=" + numHospedes +
                ", caracteristicas='" + caracteristicas + '\'' +
                '}';
    }
}
