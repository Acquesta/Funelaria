package br.com.funilaria.models;

import java.util.Date;
import java.util.List;

public class Funileiro extends Usuario{

    private List<Date> horariosDisponiveis;
    private List<Date> horariosMarcados;

    public Funileiro(String nome, String numero, String cpf, String email) {
        super(nome, numero, cpf, email);
    }

    public List<Date> adicionarHoarariosDisponiveis(Date horario){
        horariosDisponiveis.add(horario);
        return horariosDisponiveis;
    }

    public List<Date> marcarHorarioAgenda(Date horario){

        boolean disponivel = horariosDisponiveis.stream()
                .anyMatch(d -> d.equals(horario));

        if (disponivel){
            horariosMarcados.add(horario);
            horariosDisponiveis.remove(horario);
        }

        return horariosDisponiveis;
    }
}
