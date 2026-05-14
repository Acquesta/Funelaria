package br.com.funilaria.models;

import br.com.funilaria.repositories.CarroRepository;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carros")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente dono;

    public Carro(String modelo, String marca, String placa, int ano, String problema) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.problema = problema;
    }


}
