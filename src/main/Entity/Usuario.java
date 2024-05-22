package Entity;


public class Usuario {
    private String nome;
    private String email;
    private String username;
    private String senha;


    public Usuario(String nome, String email, String username, String senha){
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

    public String getNome() {return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    @Override
    public String toString() {
        return getClass().getSimpleName() + "," + nome + "," + email + "," + username + "," + senha;
    }

    public static Usuario fromString(String usuarioStr) {
        String[] partes = usuarioStr.split(",");
        String tipo = partes[0];
        String nome = partes[1];
        String email = partes[2];
        String username = partes[3];
        String senha = partes[4];

        switch (tipo) {
            case "Hospede":
                return new Hospede(nome, email, username, senha);
            case "Anfitriao":
                return new Anfitriao(nome, email, username, senha);
            default:
                throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);
        }
    }
}
