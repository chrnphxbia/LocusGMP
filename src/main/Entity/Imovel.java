package Entity;

import java.util.List;

public class Imovel {
    private String id;
    private String endereco;
    private List<String> datasDisponiveis;
    private String tipoImovel;
    private int nHospedes;
    private int nQuartos;
    private int nBanheiros;
    private float avaliacao;
    private float preco;

    public Imovel(String id, String endereco, List<String> datasDisponiveis, String tipoImovel, int nHospedes, int nQuartos, int nBanheiros, float avaliacao, float preco) {
        this.id = id;
        this.endereco = endereco;
        this.datasDisponiveis = datasDisponiveis;
        this.tipoImovel = tipoImovel;
        this.nHospedes = nHospedes;
        this.nQuartos = nQuartos;
        this.nBanheiros = nBanheiros;
        this.avaliacao = avaliacao;
        this.preco = preco;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

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

    public float getAvaliacao() {return avaliacao;}
    public void setAvaliacao(float avaliacao) {this.avaliacao = avaliacao;}

    public float getPreco() {return preco;}
    public void setPreco(float preco) {this.preco = preco;}

    @Override
    public String toString() {
        return endereco + "," + String.join(";", datasDisponiveis) + "," + tipoImovel + "," + nHospedes + "," + nQuartos + "," + nBanheiros + "," + avaliacao + "," + preco;
    }

    public Imovel fromString(String imovelStr) {
        String[] partes = imovelStr.split(",");
        String id = partes[0];
        String endereco = partes[1];
        List<String> datasDisponiveis = List.of(partes[2].split(";"));
        String tipoImovel = partes[3];
        int nHospedes = Integer.parseInt(partes[4]);
        int nQuartos = Integer.parseInt(partes[5]);
        int nBanheiros = Integer.parseInt(partes[6]);
        float avaliacao = Float.parseFloat(partes[7]);
        float preco = Float.parseFloat(partes[8]);
        return new Imovel(id, endereco, datasDisponiveis, tipoImovel, nHospedes, nQuartos, nBanheiros, avaliacao, preco);
    }
}
