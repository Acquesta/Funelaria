package br.com.funilaria.controllers;

import br.com.funilaria.DTOs.AtualizarClienteDTO;
import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.DTOs.StatusExclusaoDTO;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.sevices.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public Page<ClienteDTO> listarClientes(@PageableDefault Pageable pageable){
        return service.listarClientes(pageable);
    }
    
    @GetMapping("/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id){
        return service.buscarCliente(id);
    }

    @PostMapping
    public ClienteDTO criarNovoCliente(@Valid @RequestBody ClienteDTO dados) {
        return service.cadastrar(dados);
    }

    @DeleteMapping("/{id}")
    public StatusExclusaoDTO deletarCliente(@PathVariable Long id){
        return service.deletarCliente(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizarCliente(@PathVariable Long id, @RequestBody AtualizarClienteDTO dados){
        ClienteDTO clieteAtualizado = service.atualizarCliente(id, dados);

        return clieteAtualizado;
    }
}
