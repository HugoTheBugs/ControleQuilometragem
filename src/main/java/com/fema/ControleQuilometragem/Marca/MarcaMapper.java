package com.fema.ControleQuilometragem.Marca;

import org.springframework.stereotype.Component;

@Component
public class MarcaMapper {

    public MarcaModel map(MarcaDTO marcaDTO){
        MarcaModel marcaModel = new MarcaModel();
        marcaModel.setId(marcaDTO.getId());
        marcaModel.setNome(marcaDTO.getNome());
        return marcaModel;
    }

    public MarcaDTO map(MarcaModel marcaModel){
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setId(marcaModel.getId());
        marcaDTO.setNome(marcaModel.getNome());
        return marcaDTO;
    }
}