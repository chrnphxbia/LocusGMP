package Entity;

import java.util.List;

public class Imovel {
    private String endereco;
    private List<String> datasDisponiveis;
    private String tipoImovel;
    private int nHospedes;
    private int nQuartos;
    private int nBanheiros;
    private double avaliacao;
    private double preco;

    public Imovel(String endereco, List<String> datasDisponiveis, String tipoImovel, int nHospedes, int nQuartos, int nBanheiros, double avaliacao, double preco) {
        this.endereco = endereco;
        this.datasDisponiveis = datasDisponiveis;
        this.tipoImovel = tipoImovel;
        this.nHospedes = nHospedes;
        this.nQuartos = nQuartos;
        this.nBanheiros = nBanheiros;
        this.avaliacao = avaliacao;
        this.preco = preco;
    }


    public getEndereco() {return endereco;}
    public setEndereco(String endereco) {this.endereco = endereco;}

    public List<String> getDatasDisponiveis() {return datasDisponiveis;}
    public void setDatasDisponiveis(List<String> datasDisponiveis) {this.datasDisponiveis = datasDisponiveis;}

    public String getTipoImovel(){return tipoImovel;}
    public void setTipoImovel(String tipoImovel){this.tipoImovel = tipoImovel;}

    public int getNHospedes(){return nHospedes;}
    public void setNHospedes(int nHospedes){this.nHospedes = nHospedes;}

    public int getNQuartos(){return nQuartos;}
    public void setNQuartos(int nQuartos){this.nQuartos = nQuartos;}

    public int getNBanheiros() {return nBanheiros;}
    public void setNBanheiros(int nBanheiros) {this.nBanheiros = nBanheiros;}

    public double getAvaliacao() {return avaliacao;}
    public void setAvaliacao(double avaliacao) {this.avaliacao = avaliacao;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

    @Override
    public String toString() {
        return endereco + "," + String.join(";", datasDisponiveis) + "," + tipoImovel + "," + nHospedes + "," + nQuartos + "," + nBanheiros + "," + avaliacao + "," + preco;
    }

    public Imovel fromString(String imovelStr) {
        String[] partes = imovelStr.split(",");
        String endereco = partes[0];
        List<String> datasDisponiveis = List.of(partes[1].split(";"));
        String tipoImovel = partes[2];
        int nHospedes = Integer.parseInt(partes[3]);
        int nQuartos = Integer.parseInt(partes[4]);
        int nBanheiros = Integer.parseInt(partes[5]);
        double avaliacao = Double.parseDouble(partes[6]);
        double preco = Double.parseDouble(partes[7]);
        return new Imovel(endereco, datasDisponiveis, tipoImovel, nHospedes, nQuartos, nBanheiros, avaliacao, preco);
    }
}
