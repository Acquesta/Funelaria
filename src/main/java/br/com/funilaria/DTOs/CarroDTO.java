package br.com.funilaria.DTOs;

import br.com.funilaria.models.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class CarroDTO {

    @Getter
    @Setter
    private String modelo;

    @Getter
    @Setter
    private String marca;

    @Getter
    @Setter
    private String placa;

    @Getter
    @Setter
    private int ano;

    @Getter
    @Setter
    private String problema;

    public CarroDTO(String modelo, String marca, String placa, int ano, String problema) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.problema = problema;
    }
}
