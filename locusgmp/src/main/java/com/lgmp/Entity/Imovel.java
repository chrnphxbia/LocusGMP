package com.lgmp.Entity;

import java.util.ArrayList;

public class Imovel {
    private String id;
    private String nome;
    private String status;
    private String endereco;
    private double valorDiaria;
    private int numeroHospedes;
    private Anfitriao anfitriao;
    private ArrayList<Integer> datasDisponiveis;

    public Imovel(String id, String nome, String status, String endereco,
    double valorDiaria, int numeroHospedes, Anfitriao anfitriao, ArrayList<Integer> datas) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.endereco = endereco;
        this.valorDiaria = valorDiaria;
        this.numeroHospedes = numeroHospedes;
        this.anfitriao = anfitriao;
        this.datasDisponiveis = datas;
    }

    public String getID() { return this.id; }
    public String getNome() { return this.nome; }
    public String getStatus() { return this.status; }
    public String getEndereco() { return this.endereco; }
    public double getValorDiaria() { return this.valorDiaria; }
    public int getNumeroHospedes() { return this.numeroHospedes; }
    public Anfitriao getAnfitriao() { return this.anfitriao; }
    public ArrayList<Integer> datasDisponiveis() { return this.datasDisponiveis; }

    public void setID(String id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setStatus(String status) { this.status = status; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }
    public void setNumeroHospedes(int numeroHospedes) { this.numeroHospedes = numeroHospedes; }
    public void setAnfitriao(Anfitriao anfitriao) { this.anfitriao = anfitriao; }
    public void setDatas(ArrayList<Integer> datas) { this.datasDisponiveis = datas; }  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id).append("; Nome: " + nome).append("; Status: " + status)
        .append("; Endereço: " + endereco).append("; Valor: " + valorDiaria)
        .append("; Numero de Hóspedes: " + numeroHospedes).append("; Anfitrião: " + anfitriao.getNome())
        .append("; Datas disponíveis: ");

        for (Integer data : datasDisponiveis) {
            sb.append(data);
            if(datasDisponiveis.indexOf(data) != datasDisponiveis.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
