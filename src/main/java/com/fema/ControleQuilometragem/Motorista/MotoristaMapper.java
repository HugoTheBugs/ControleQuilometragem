package com.fema.ControleQuilometragem.Motorista;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MotoristaMapper {

    public MotoristaModel map(MotoristaDTO motoristaDTO){
        MotoristaModel motoristaModel = new MotoristaModel();
        motoristaModel.setId(motoristaDTO.getId());
        motoristaModel.setNome(motoristaDTO.getNome());
        motoristaModel.setCnh(motoristaDTO.getCnh());
        motoristaModel.setCnh_categoria(motoristaDTO.getCnh_categoria());
        motoristaModel.setCnh_vencimento(motoristaDTO.getCnh_vencimento());
        motoristaModel.setTelefone(motoristaDTO.getTelefone());
        motoristaModel.setStatus(motoristaDTO.getStatus());

        return motoristaModel;
    }

    public MotoristaDTO map(MotoristaModel motoristaModel){
        MotoristaDTO motoristaDTO = new MotoristaDTO();
        motoristaDTO.setId(motoristaModel.getId());
        motoristaDTO.setNome(motoristaModel.getNome());
        motoristaDTO.setCnh(motoristaModel.getCnh());
        motoristaDTO.setCnh_categoria(motoristaModel.getCnh_categoria());
        motoristaDTO.setCnh_vencimento(motoristaModel.getCnh_vencimento());
        motoristaDTO.setTelefone(motoristaModel.getTelefone());
        motoristaDTO.setStatus(motoristaModel.getStatus());

        return motoristaDTO;
    }
}
