package br.com.funilaria.DTOs;

import lombok.Getter;
import lombok.Setter;

public class ErroDeNaoEncontrado {
    @Getter
    @Setter
    private String mensagem;

    public ErroDeNaoEncontrado(String mensagem) {
        this.mensagem = mensagem;
    }
}
