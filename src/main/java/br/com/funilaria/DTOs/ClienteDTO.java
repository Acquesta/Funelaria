package br.com.funilaria.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class ClienteDTO {
    @Getter
    @Setter
    private Long id;
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

    public ClienteDTO(String nome, String numero, String cpf, String email, Long id) {
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
        this.id = id;
    }

}
