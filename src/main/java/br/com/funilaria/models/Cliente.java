package br.com.funilaria.models;

import br.com.funilaria.DTOs.StatusExclusaoDTO;
import br.com.funilaria.FunilariaApplication;
import br.com.funilaria.interfaces.ICliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "clientes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cliente extends Usuario implements ICliente {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataMarcada;

    @OneToMany(mappedBy = "dono")
    private List<Carro> carros = new ArrayList<>();

    @Getter
    @Setter
    private boolean ativo = true;

    public Cliente(String nome, String numero, String cpf, String email) {
        super(nome, numero, cpf, email);
    }

    @Override
    public Carro cadastrarCarro(String modelo, String marca, String placa, int ano, String problema) {
        Carro novo_carro = new Carro(modelo, marca, placa, ano, problema);
        this.carros.add(novo_carro);
        return novo_carro;
    }

    @Override
    public List<Date> marcarVistoria(Date horarioPossivel, Funileiro funileiro) {
        List<Date> horariosDisponiveis = funileiro.marcarHorarioAgenda(horarioPossivel);

        return horariosDisponiveis;
    }
//
//    public StatusExclusaoDTO alterarStatus(){
//        this.ativo = !ativo;
//        return new StatusExclusaoDTO(this.ativo,"Status do cliente alterado");
//    }
}
