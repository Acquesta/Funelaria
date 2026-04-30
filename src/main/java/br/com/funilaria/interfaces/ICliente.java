package br.com.funilaria.interfaces;

import br.com.funilaria.models.Carro;
import br.com.funilaria.models.Funileiro;

import java.util.Date;
import java.util.List;

public interface ICliente {
    Carro cadastrarCarro(String modelo, String marca, String placa, int ano, String problema);
    List<Date> marcarVistoria(Date horarioPossivel, Funileiro funileiro);
}
