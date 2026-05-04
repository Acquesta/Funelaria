package br.com.funilaria.sevices;

import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.exceptions.RegraDeNegocioException;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrar(ClienteDTO cliente){

        // Barreira de segurança ANTES de encostar no banco:
        if (repository.existsByCpf(cliente.getCpf())) {
            throw new RegraDeNegocioException("cpf", "Este CPF já está cadastrado!");
        }

        Cliente novo_cliente = new Cliente(
                cliente.getNome(),
                cliente.getNumero(),
                cliente.getCpf(),
                cliente.getEmail());

        return repository.save(novo_cliente);
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }
}
