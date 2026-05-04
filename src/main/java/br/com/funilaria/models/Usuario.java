package br.com.funilaria.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@MappedSuperclass
public class Usuario {
    @Setter
    @Getter
    @NonNull
    private String nome;
    @Getter
    @Setter
    @NonNull
    @Column(unique = true)
    private String numero;
    @Getter
    @Setter
    @NonNull
    @Column(unique = true)
    private String cpf;
    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    public Usuario(@NonNull String nome, @NonNull String numero, @NonNull String cpf, String email) {
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuario(){};

}
