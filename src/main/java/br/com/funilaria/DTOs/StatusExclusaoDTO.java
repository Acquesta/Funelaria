package br.com.funilaria.DTOs;

import lombok.Getter;
import lombok.Setter;

public class StatusExclusaoDTO {

    @Getter
    @Setter
    private boolean status;

    @Getter
    @Setter
    private String mensagem;

    public StatusExclusaoDTO(boolean status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
}
