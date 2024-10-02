package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        uc.createUser(new Usuario(
            "",
            "Jose",
            30,
            "Rua 1, 100"
        ));
    }
}