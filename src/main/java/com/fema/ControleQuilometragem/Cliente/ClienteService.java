package com.fema.ControleQuilometragem.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
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
}
