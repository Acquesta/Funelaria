package br.com.funilaria.controllers;

import br.com.funilaria.DTOs.ClienteDTO;
import br.com.funilaria.models.Cliente;
import br.com.funilaria.sevices.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listarClientes(){
        return service.listarClientes();
    }

    @PostMapping
    public Cliente criarNovoCliente(@Valid @RequestBody ClienteDTO dados) {

        return service.cadastrar(dados);
    }
}
