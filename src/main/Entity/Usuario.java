package Entity;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String tipoUsuario;
    private String nome;
    private String email;
    private String username;
    private String senha;
    private List<Reserva> listaReservas;


    public Usuario(String tipoUsuario, String nome, String email, String username, String senha){
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.listaReservas = new LinkedList<>();
    }

    public String getTipoUsuario() {return tipoUsuario;}
    public void setTipoUsuario(String tipoUsuario){this.tipoUsuario = tipoUsuario;}

    public String getNome() {return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}


    public List<Reserva> getListaReservas() {return listaReservas;}
    public void addReserva(String id, Anfitriao anfitriao, Hospede hospede, String dataInicio, String dataFim, String pagamento, float valor, Imovel imovel, int nHospedes) {
        Reserva reserva = new Reserva(id, anfitriao, hospede, dataInicio, dataFim, pagamento, valor, imovel, nHospedes, "Reservado");
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "," + nome + "," + email + "," + username + "," + senha;
    }
}
