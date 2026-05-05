package br.com.funilaria.controllers;

import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.sevices.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ClienteDTO> listarClientes(){
        return service.listarClientes();
    }
    
    @GetMapping("/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id){
        return service.buscarCliente(id);
    }

    @PostMapping
    public Cliente criarNovoCliente(@Valid @RequestBody ClienteDTO dados) {
        return service.cadastrar(dados);
    }
}
