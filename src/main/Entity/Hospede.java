package Entity;

import java.util.LinkedList;
import java.util.List;

public class Hospede {
    private String nome;
    private List<String> listaPagamentos;
    private List<reserva> listaReservas;

    public Hospede(String nome){
    this.nome = nome;
    listaPagamentos = new LinkedList<>();
    listaReservas = new LinkedList<>();
}

    public String getNome(){return nome;}
    public String setNome(String nome){this.nome = nome;}

    public List<String> getListaPagamentos() {return listaPagamentos;}
    public void setListaPagamentos(List<String> listaPagamentos) {this.listaPagamentos = listaPagamentos;}

    public void setListaReservas(List<reserva> listaReservas) {this.listaReservas = listaReservas;}
    public List<reserva> getListaReservas() {return listaReservas;}


    public String getPagamentos() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < listaPagamentos.size(); ++i) {
            sb.append("\n").append(i+1).append(". ").append(listaPagamentos.get(i));
        }
        return sb.toString();
    }
    public void addPagamento(String pagamento) {listaPagamentos.add(pagamento);}
    public void removePagamento(String pagamento) {listaPagamentos.remove(pagamento);}

    public String getReservas() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < listaReservas.size(); ++i) {
        sb.append("\n").append(i+1).append(". ").append(listaReservas.get(i));
    }
    return sb.toString();
}
    public void addReserva(reserva reserva) {listaReservas.add(reserva);}
    public void removeReserva(reserva reserva) {listaReservas.remove(reserva);}


@Override
public String toString() {return nome;}
}