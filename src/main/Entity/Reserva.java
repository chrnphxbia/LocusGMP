package Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private String id;
    private Anfitriao anfitriao;
    private Hospede hospede;
    private String dataInicio;
    private String dataFim;
    private String pagamento;
    private float valor;
    private Imovel imovel;
    private int nHospedes;


    public Reserva(String id, Anfitriao anfitriao, Hospede hospede, String dataInicio, String dataFim, String pagamento, float valor, Imovel imovel, int nHospedes){
        this.id = id;
        this.anfitriao = anfitriao;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pagamento = pagamento;
        this.valor = valor;
        this.imovel = imovel;
        this.nHospedes = nHospedes;
    }

    public String getIdR() {return id;}
    public void setIdR(String id) {this.id = id;}

    public Anfitriao getAnfitriao(){return anfitriao;}
    public void setAnfitriao(Anfitriao anfitriao){this.anfitriao = anfitriao;}

    public Hospede getHospede(){return hospede;}
    public void setHospede(Hospede hospede){this.hospede = hospede;}

    public String getDataInicio(){return dataInicio;}
    public void setDataInicio(String dataInicio){this.dataInicio = dataInicio;}

    public String getDataFim(){return dataFim;}
    public void setDataFim(String dataFim){this.dataFim = dataFim;}

    public String getPagamento(){return pagamento;}
    public void setPagamento(String pagamento){this.pagamento = pagamento;}

    public float getValor(){return valor;}
    public void setValor(float valor){this.valor = valor;}

    public Imovel getImovel(){return imovel;}
    public void setImovel(Imovel imovel){this.imovel = imovel;}

    public int getNHospedes(){return nHospedes;}
    public void setNHospedes(int nHospedes){this.nHospedes = nHospedes;}

}
