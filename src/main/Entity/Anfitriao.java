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
        this.contaBancaria = contaBancaria;
        this.listaImoveis = new LinkedList<>();
        this.listaReservas = new LinkedList<>();
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Imovel> getListaImoveis() {return listaImoveis;}
    public void setListaImoveis(List<Imovel> listaImovel) {this.listaImoveis = listaImovel;}

    public String getContaBancaria() {return contaBancaria;}
    public void setContaBancaria(String contaBancaria) {this.contaBancaria = contaBancaria;}

    public List<Reserva> getListaReservas() {return listaReservas;}
    public void addReserva(Reserva reserva) {listaReservas.add(reserva);}
    public void removeReserva(Reserva reserva) {listaReservas.remove(reserva);}

    public void addImovel(String id, String endereco, List<String> datasDisponiveis, String tipoImovel, int nHospedes, int nQuartos, int nBanheiros, float avaliacao, float preco) {
        Imovel imovel = new Imovel(id, endereco, datasDisponiveis, tipoImovel, nHospedes, nQuartos, nBanheiros, avaliacao, preco);
        listaImoveis.add(imovel);
    }

    public void removeImovel(Imovel Imovel) {listaImoveis.remove(Imovel);}

    public Imovel getImovel(String id) {
        for(int i = 0; i < listaImoveis.size(); ++i) {
            if(listaImoveis.get(i).getId() == id) {
                return listaImoveis.get(i);
            }
        }

        return null;
    }

}
