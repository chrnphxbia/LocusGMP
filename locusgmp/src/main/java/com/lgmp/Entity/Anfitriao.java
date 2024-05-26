package com.lgmp.Entity;

import java.util.ArrayList;

public class Anfitriao extends Usuario {
    private ArrayList<Imovel> imoveis;

    public Anfitriao(String nomeDeUsuario, String senha, String nome) {
        super(nomeDeUsuario, "Anfitriao", senha, nome);
        this.imoveis = new ArrayList<>();
    }

    public ArrayList<Imovel> getImoveis() { return imoveis; }

    public void setImoveis(ArrayList<Imovel> imoveis) { this.imoveis = imoveis; }

    public void addImovel(Imovel novoImovel) {
        this.imoveis.add(novoImovel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; Imóveis: ");

        for (Imovel imovel : imoveis) {
            sb.append(imovel.getID());
            if(imoveis.indexOf(imovel) != imoveis.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
