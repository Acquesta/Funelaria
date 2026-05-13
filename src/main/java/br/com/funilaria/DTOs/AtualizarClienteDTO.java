package br.com.funilaria.DTOs;

import lombok.Getter;
import lombok.Setter;

public class AtualizarClienteDTO {
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String numero;

    @Getter
    @Setter
    private String email;

    public AtualizarClienteDTO(String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }
}
