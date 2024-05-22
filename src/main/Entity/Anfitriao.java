package Entity;

import java.util.LinkedList;
import java.util.List;

public class Anfitriao {
    private String nome;
    private String contaBancaria;
    private List<Imovel> listaImoveis;
    private List<Reserva> listaReservas;

    public Anfitriao(String nome, String contaBancaria){
        this.nome = nome;
        this.contaBancaria = contaBancaria.
        listaImoveis = new LinkedList();
        listaReservas = new LinkedList();
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Imovel> getListaImoveis() {return listaImoveis;}
    public void setListaImoveis(List<Imovel> listaImovel) {this.listaImovel = listaImovel;}

    public String getContaBancaria() {return contaBancaria;}
    public void setContaBancaria(String contaBancaria) {this.contaBancaria = contaBancaria;}

    public List<Reserva> getListaReservas() {return listaReservas;}
    public void addReserva(Reserva reserva) {listaReservas.add(reserva);}
    public void removeReserva(Reserva reserva) {listaReservas.remove(reserva);}

    public void addImovel(TipoImovel tipoImovel, String aparelho, double orcamento) {
        Imovel Imovel = new Imovel(tipoImovel, aparelho, orcamento);
        listaImovels.add(Imovel);
    }

    public void removeImovel(Imovel Imovel) {listaImovels.remove(Imovel);}

    public Imovel getImovel(TipoImovel Imovel, String aparelho) {
        for(int i = 0; i < listaImovels.size(); ++i) {
            if(listaImovels.get(i).getTipoImovel() == Imovel && listaImovels.get(i).getAparelho().equals(aparelho)) {
                return listaImovels.get(i);
            }
        }

        return null;
    }

}
