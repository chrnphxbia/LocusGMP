package Entity;

import java.util.LinkedList;
import java.util.List;

public class Hospede extends Usuario{
    private List<String> listaPagamentos;

    public Hospede(String nome, String email, String username, String senha){
    super("hospede", nome, email, username, senha);
    this.listaPagamentos = new LinkedList<>();
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
}

//Entidades: Armazenar e fornecer