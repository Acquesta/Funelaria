package br.com.funilaria.interfaces;

import br.com.funilaria.models.Carro;
import br.com.funilaria.models.Funileiro;

import java.util.Date;
import java.util.List;

public interface ICliente {
    List<Date> marcarVistoria(Date horarioPossivel, Funileiro funileiro);
}
