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
    public String getPagamentos() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < listaPagamentos.size(); ++i) {
            sb.append("\n").append(i+1).append(". ").append(listaPagamentos.get(i));
        }
        return sb.toString();
    }
    public void addPagamento(String pagamento) {listaPagamentos.add(pagamento);}
    public void removePagamento(String pagamento) {listaPagamentos.remove(pagamento);}

    public List<Reserva> getListaReservas() {return listaReservas;}
    public void addReserva(String id, Anfitriao anfitriao, Hospede hospede, String dataInicio, String dataFim, String pagamento, float valor, Imovel imovel, int nHospedes) {
        Reserva reserva = new Reserva(id, anfitriao, hospede, dataInicio, dataFim, pagamento, valor, imovel, nHospedes);
        listaReservas.add(reserva);
    }
    public void removeReserva(Reserva reserva) {listaReservas.remove(reserva);}
    public Reserva getReserva(String id) {
        for(int i = 0; i < listaReservas.size();++i){
            if(listaReservas.get(i).getIdR() == id){
                return listaReservas.get(i);
            }
        }
        return null;
    }

}