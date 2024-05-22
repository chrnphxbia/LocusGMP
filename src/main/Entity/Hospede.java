package Entity;

import java.util.LinkedList;
import java.util.List;

public class Hospede extends Usuario{
    private List<String> listaPagamentos;
    private List<Reserva> listaReservas;

    public Hospede(String nome, String email, String username, String senha){
    super(nome, email, username, senha);
    this.listaPagamentos = new LinkedList<>();
    this.listaReservas = new LinkedList<>();
}

    public List<String> getListaPagamentos() {return listaPagamentos;}
    public void setListaPagamentos(List<String> listaPagamentos) {this.listaPagamentos = listaPagamentos;}

    public void setListaReservas(List<Reserva> listaReservas) {this.listaReservas = listaReservas;}
    public List<Reserva> getListaReservas() {return listaReservas;}


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
    public void addReserva(Reserva reserva) {listaReservas.add(reserva);}
    public void removeReserva(Reserva reserva) {listaReservas.remove(reserva);}

}