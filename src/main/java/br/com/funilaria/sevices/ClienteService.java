package br.com.funilaria.sevices;

import br.com.funilaria.DTOs.AtualizarClienteDTO;
import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.DTOs.StatusExclusaoDTO;
import br.com.funilaria.exceptions.RecursoNaoEncontradoException;
import br.com.funilaria.exceptions.RegraDeNegocioException;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ClienteDTO cadastrar(ClienteDTO cliente){

        // Barreira de segurança ANTES de encostar no banco:
        if (repository.existsByCpf(cliente.getCpf())) {
            throw new RegraDeNegocioException("cpf", "Este CPF já está cadastrado!");
        } else if (repository.existsByEmail(cliente.getEmail())){
            throw new RegraDeNegocioException("email", "Este email já existe!");
        } else if (repository.existsByNumero(cliente.getNumero())){
            throw new RegraDeNegocioException("numero", "Este número já existe!");
        }

        repository.save(new Cliente(
                cliente.getNome(),
                cliente.getNumero(),
                cliente.getCpf(),
                cliente.getEmail()));

        return cliente;
    }

    public Page<ClienteDTO> listarClientes(Pageable pageable){

        Page<Cliente> clientes = repository.findAllByAtivoTrue(pageable);

        return clientes.map(c -> new ClienteDTO(
                        c.getNome(),
                        c.getNumero(),
                        c.getCpf(),
                        c.getEmail()
                        ));
    }

    public ClienteDTO buscarCliente(Long id){
        Cliente buscaCliente = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        return new ClienteDTO(buscaCliente.getNome(),
                buscaCliente.getNumero(),
                buscaCliente.getCpf(),
                buscaCliente.getEmail());

    }

    public StatusExclusaoDTO deletarCliente(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        cliente.setAtivo(false);

        repository.save(cliente);

        return new StatusExclusaoDTO(false, "Cliente excluido com sucesso");
    }

    public ClienteDTO atualizarCliente(Long id, AtualizarClienteDTO dados){
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        if(dados.getNome() == null && dados.getNumero() == null && dados.getEmail() == null){
            throw new RecursoNaoEncontradoException("É necessario passar algum dado para alterar");
        }
        if(dados.getNome() != null){
            cliente.setNome(dados.getNome());
        }
        if(dados.getNumero() != null){
            cliente.setNumero(dados.getNumero());
        }
        if(dados.getEmail() != null){
            cliente.setEmail(dados.getEmail());
        }

        Cliente clienteSalvo = repository.save(cliente);

        return new ClienteDTO(clienteSalvo.getNome(),
                clienteSalvo.getNumero(),
                clienteSalvo.getCpf(),
                cliente.getEmail());
    }
}
