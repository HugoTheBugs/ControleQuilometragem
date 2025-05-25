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

    // Mostrar cliente por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarClientesPorId(@PathVariable Long id){

        ClienteDTO cliente = clienteService.listarClientesPorId(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Cliente
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarClientePorId(@PathVariable Long id){
        if(clienteService.listarClientesPorId(id) !=null){
            clienteService.deletarClientePorId(id);
            return ResponseEntity.ok("Cliente com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cliente com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Clientes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarClientePorId(@PathVariable Long id, @RequestBody ClienteDTO clienteAtualizado){
        ClienteDTO cliente = clienteService.atualizarCliente(id, clienteAtualizado);

        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
