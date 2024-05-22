package Entity;

import java.util.LinkedList;
import java.util.List;

public class Anfitriao extends Usuario{
    private String contaBancaria;
    private List<Imovel> listaImoveis;
    private List<Reserva> listaReservas;

    public Anfitriao(String nome, String email, String username, String senha, String contaBancaria){
        super(nome, email, username, senha);
        this.contaBancaria = contaBancaria;
        this.listaImoveis = new LinkedList<>();
    }

    public String getContaBancaria() {return contaBancaria;}
    public void setContaBancaria(String contaBancaria) {this.contaBancaria = contaBancaria;}

    public List<Imovel> getListaImoveis() {return listaImoveis;}
    public void addImovel(String id, String endereco, List<String> datasDisponiveis, String tipoImovel, int nHospedes, int nQuartos, int nBanheiros, float avaliacao, float preco) {
        Imovel imovel = new Imovel(id, endereco, datasDisponiveis, tipoImovel, nHospedes, nQuartos, nBanheiros, avaliacao, preco);
        listaImoveis.add(imovel);
    }
    public void removeImovel(Imovel imovel) {listaImoveis.remove(imovel);}
    public Imovel getImovel(String id) {
        for(int i = 0; i < listaImoveis.size(); ++i) {
            if(listaImoveis.get(i).getId() == id) {
                return listaImoveis.get(i);
            }
        }

        return null;
    }


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
