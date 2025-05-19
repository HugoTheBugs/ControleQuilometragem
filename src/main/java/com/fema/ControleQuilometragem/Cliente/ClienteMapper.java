package com.fema.ControleQuilometragem.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    ClienteModel map(ClienteDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setCnpj(clienteDTO.getCnpj());
        clienteModel.setEndereco(clienteDTO.getEndereco());
        return clienteModel;
    }

    ClienteDTO map(ClienteModel clienteModel){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setCnpj(clienteModel.getCnpj());
        clienteDTO.setEndereco(clienteModel.getEndereco());
        return clienteDTO;
    }
}
