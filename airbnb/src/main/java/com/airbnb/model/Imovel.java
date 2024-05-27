package com.airbnb.model;

import java.io.Serializable;

public class Imovel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int anfitriaoId;

    public Imovel(int id, String nome, String descricao, double preco, int anfitriaoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.anfitriaoId = anfitriaoId;
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

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", anfitriaoId=" + anfitriaoId +
                '}';
    }
}
