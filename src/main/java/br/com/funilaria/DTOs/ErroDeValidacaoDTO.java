package br.com.funilaria.DTOs;

import lombok.Getter;

public class ErroDeValidacaoDTO {
    @Getter
    private String campo;
    @Getter
    private String mensagem;

    public ErroDeValidacaoDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
