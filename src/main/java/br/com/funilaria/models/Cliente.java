package br.com.funilaria.models;

import br.com.funilaria.FunilariaApplication;
import br.com.funilaria.interfaces.ICliente;

import java.util.*;


public class Cliente extends Usuario implements ICliente {

    private Date dataMarcada;
    private Carro carro;

    public Cliente(String nome, String numero, String cpf, String email) {
        super(nome, numero, cpf, email);
    }

    @Override
    public Carro cadastrarCarro(String modelo, String marca, String placa, int ano, String problema) {
        this.carro = new Carro(modelo, marca, placa, ano, problema);
        return carro;
    }

    @Override
    public List<Date> marcarVistoria(Date horarioPossivel, Funileiro funileiro) {
        List<Date> horariosDisponiveis = funileiro.marcarHorarioAgenda(horarioPossivel);

        return horariosDisponiveis;
    }
}
