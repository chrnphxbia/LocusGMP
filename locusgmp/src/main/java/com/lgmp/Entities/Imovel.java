package com.lgmp.Entities;

public class Imovel {
    private String id;
    private String nome;
    private float valor;
    private String status;
    private String endereco;
    private String descricao;
    private int numeroHospedes;
    private String[] datasDisponiveis;
    private String[] datasIndisponiveis;

    public Imovel(String idArg, String nomeArg, float valorArg, String statusArg, 
    String enderecoArg, String descricaoArg, int numHospedesArg) {
        this.id = idArg;
        this.nome = nomeArg;
        this.valor = valorArg;
        this.status = statusArg;
        this.endereco = enderecoArg;
        this.descricao = descricaoArg;
        this.numeroHospedes = numHospedesArg;

    }

    public String getID() { return this.id; }
    public String getNome() { return this.nome; }
    public float getValor() { return this.valor; }
    public String getStatus() { return this.status; }
    public String getEndereco() { return this.endereco; }
    public String getDescricao() { return this.descricao; }
    public int getNumeroHospedes() { return this.numeroHospedes; }
    public String[] getDatasDisponiveis() { return this.datasDisponiveis; }
    public String[] getDatasIndisponiveis() { return this.datasIndisponiveis; }

    public void setID(String idArg) { this.id = idArg; }  
    public void setNome(String nomeArg) { this.nome = nomeArg; }
    public void setValor(float valorArg) { this.valor = valorArg; }
    public void setStatus(String statusArg) { this.status = statusArg; }
    public void setEndereco(String enderecoArg) { this.endereco = enderecoArg; }
    public void setDescricao(String descricaoArg) { this.descricao = descricaoArg; }
    public void setNumeroHospedes(int numeroHospedesArg) { this.numeroHospedes = numeroHospedesArg; }
    public void setDatasDisponiveis(String[] datasArg) { this.datasDisponiveis = datasArg; }
    public void setDatasIndisponiveis(String[] datasArg) { this.datasIndisponiveis = datasArg; }
}
