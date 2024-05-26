package com.lgmp.Entities;

public class Usuario {
    private String username;
    private String password;
    private String name;
    private String tipo; // Hospede ou Anfitrião

    public Usuario(String usernameArg, String passwordArg, String nameArg, String tipoArg) {
        this.username = usernameArg;
        this.password = passwordArg;
        this.name = nameArg;
        this.tipo = tipoArg;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public String getName() { return this.name; }
    public String getTipo() { return this.tipo; }

    public void setUsername(String usernameArg) { this.username = usernameArg; }
    public void setPassword(String passwordArg) { this.password = passwordArg; }
    public void setName(String nameArg) { this.name = nameArg; }
    public void setTipo(String tipoArg) { this.tipo = tipoArg; }

    @Override
    public String toString() {
        return "Nome de usuário: " + username + "; Senha: " + password + 
        "; Nome: " + name + "; Tipo: " + tipo;
    }
}
