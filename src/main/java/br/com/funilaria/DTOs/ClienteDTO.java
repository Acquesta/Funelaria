package br.com.funilaria.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO {
    @Getter
    @Setter
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @Getter
    @Setter
    @NotBlank(message = "O número não pode estar vazio")
    private String numero;
    @Getter
    @Setter
    @NotBlank(message = "O cpf não pode estar vazio")
    private String cpf;
    @Getter
    @Setter
    private String email;
}
