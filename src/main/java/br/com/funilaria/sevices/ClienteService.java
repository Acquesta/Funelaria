package br.com.funilaria.sevices;

import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.exceptions.RecursoNaoEncontradoException;
import br.com.funilaria.exceptions.RegraDeNegocioException;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrar(ClienteDTO cliente){

        // Barreira de segurança ANTES de encostar no banco:
        if (repository.existsByCpf(cliente.getCpf())) {
            throw new RegraDeNegocioException("cpf", "Este CPF já está cadastrado!");
        } else if (repository.existsByEmail(cliente.getEmail())){
            throw new RegraDeNegocioException("email", "Este email já existe!");
        }

        Cliente novo_cliente = new Cliente(
                cliente.getNome(),
                cliente.getNumero(),
                cliente.getCpf(),
                cliente.getEmail());

        return repository.save(novo_cliente);
    }

    public List<ClienteDTO> listarClientes(){

        List<Cliente> clientes = repository.findAll();

        if(clientes.isEmpty()){
            throw new RecursoNaoEncontradoException("Não exite nenhum cliente cadastrado");
        }

        return clientes.stream()
                .map(c -> new ClienteDTO(
                        c.getNome(),
                        c.getNumero(),
                        c.getCpf(),
                        c.getEmail()))
                .collect(Collectors.toList());

    }

    public ClienteDTO buscarCliente(Long id){
        Cliente buscaCliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        return new ClienteDTO(buscaCliente.getNome(),
                buscaCliente.getNumero(),
                buscaCliente.getCpf(),
                buscaCliente.getEmail());

    }
}
