package br.com.funilaria.models;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
    private Long uuid;
    @Setter
    @Getter
    private String nome;
    @Getter
    @Setter
    private String numero;
    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    private String email;

    public Usuario(String nome, String numero, String cpf, String email) {
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
    }

}
