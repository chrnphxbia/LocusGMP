package com.lgmp.Entities;
import java.util.ArrayList;

public class Anfitriao extends Usuario {
    private ArrayList<Imovel> imoveis;
    
    public Anfitriao(String usernameArg, String passwordArg, String nameArg) {
        super(usernameArg, passwordArg, nameArg, "Anfitriao");
        this.imoveis = new ArrayList<Imovel>();
    }

    public String getImoveis() {
        StringBuilder sb = new StringBuilder();
        for (Imovel imovel : imoveis) {
            sb.append(imovel.getID());
        }

        return sb.toString();
    }

    public void addImovel(Imovel novoImovel) {
        this.imoveis.add(novoImovel);
    }

    public boolean hasImoveis() { return this.imoveis.size() != 0; }
    
}
