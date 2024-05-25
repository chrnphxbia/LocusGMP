package com.chrnphxbia.Entities;

public class Hospede {
    private String username;
    private String password;
    private String name;

    public Hospede(String usernameArg, String passwordArg, String nameArg) {
        this.username = usernameArg;
        this.password = passwordArg;
        this.name = nameArg;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public String getName() { return this.name; }
}
