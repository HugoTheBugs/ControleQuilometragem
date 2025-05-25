package com.fema.ControleQuilometragem.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    public ClienteRepository clienteRepository;
    public ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    //Criar Novo Cliente
    public ClienteDTO criarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = clienteMapper.map(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    //Listar Clientes
    public List<ClienteDTO> listarClientes(){
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    // Listar Clientes por ID
    public ClienteDTO listarClientesPorId(Long id){
        Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
        return clientePorId.map(clienteMapper::map).orElse(null);
    }

    // Deletar um cliente
    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }

    // Atualizar Cliente
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isPresent()){
            ClienteModel clienteAtualizado = clienteMapper.map(clienteDTO);
            clienteAtualizado.setId(id);
            ClienteModel clienteSalvo = clienteRepository.save(clienteAtualizado);
            return clienteMapper.map(clienteSalvo);
        }
        return null;
    }
}
