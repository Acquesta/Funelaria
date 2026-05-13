package br.com.funilaria.models;

import br.com.funilaria.DTOs.AtualizarClienteDTO;
import br.com.funilaria.DTOs.StatusExclusaoDTO;
import br.com.funilaria.FunilariaApplication;
import br.com.funilaria.exceptions.RecursoNaoEncontradoException;
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
    @Column(columnDefinition = "boolean default true")
    private boolean ativo = true;

    public Cliente(String nome, String numero, String cpf, String email) {
        super(nome, numero, cpf, email);
    }

    public void cadastrarCarro(Carro carro) {
        this.carros.add(carro);
        carro.setDono(this);
    }

    @Override
    public List<Date> marcarVistoria(Date horarioPossivel, Funileiro funileiro) {
        List<Date> horariosDisponiveis = funileiro.marcarHorarioAgenda(horarioPossivel);

        return horariosDisponiveis;
    }

    public void atualizarCliente(AtualizarClienteDTO dados){
        if(dados.getNome() != null){
            this.setNome(dados.getNome());
        }
        if(dados.getNumero() != null){
            this.setNumero(dados.getNumero());
        }
        if(dados.getEmail() != null){
            this.setEmail(dados.getEmail());
        }
    }
}
