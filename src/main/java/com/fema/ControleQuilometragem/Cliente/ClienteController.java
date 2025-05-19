package com.fema.ControleQuilometragem.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    //Adicionar Cliente
    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){
        ClienteDTO novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso: " + novoCliente.getNome() + " (ID): " + novoCliente.getId());
    }

    //Listar Clientes
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }
}
