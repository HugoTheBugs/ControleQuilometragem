package com.fema.ControleQuilometragem.Combustivel;

import org.springframework.stereotype.Component;

@Component
public class CombustivelMapper {

    CombustivelModel map(CombustivelDTO combustivelDTO){
        CombustivelModel combustivelModel = new CombustivelModel();
        combustivelModel.setId(combustivelDTO.getId());
        combustivelModel.setNome(combustivelDTO.getNome());
        return combustivelModel;
    }

    CombustivelDTO map(CombustivelModel combustivelModel){
        CombustivelDTO combustivelDTO = new CombustivelDTO();
        combustivelDTO.setId(combustivelModel.getId());
        combustivelDTO.setNome(combustivelModel.getNome());
        return combustivelDTO;
    }
}