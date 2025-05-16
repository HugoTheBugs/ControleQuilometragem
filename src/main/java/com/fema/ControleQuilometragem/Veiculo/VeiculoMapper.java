package com.fema.ControleQuilometragem.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public VeiculoModel map(VeiculoDTO veiculoDTO){
        VeiculoModel veiculoModel =  new VeiculoModel();
        veiculoModel.setId(veiculoDTO.getId());
        veiculoModel.setPlaca(veiculoDTO.getPlaca());
        veiculoModel.setModelo(veiculoDTO.getModelo());
        veiculoModel.setAno(veiculoDTO.getAno());
        veiculoModel.setTanqueCapacidade(veiculoDTO.getTanqueCapacidade());
        veiculoModel.setCategoria(veiculoDTO.getCategoria());
        veiculoModel.setStatus(veiculoDTO.getStatus());
        veiculoModel.setMarca(veiculoDTO.getMarca());
        veiculoModel.setCombustivel(veiculoDTO.getCombustivel());

        return veiculoModel;
    }

    public VeiculoDTO map(VeiculoModel veiculoModel){
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(veiculoModel.getId());
        veiculoDTO.setPlaca(veiculoModel.getPlaca());
        veiculoDTO.setModelo(veiculoModel.getModelo());
        veiculoDTO.setAno(veiculoModel.getAno());
        veiculoDTO.setTanqueCapacidade(veiculoModel.getTanqueCapacidade());
        veiculoDTO.setCategoria(veiculoModel.getCategoria());
        veiculoDTO.setStatus(veiculoModel.getStatus());
        veiculoDTO.setMarca(veiculoModel.getMarca());
        veiculoDTO.setCombustivel(veiculoDTO.getCombustivel());

        return veiculoDTO;
    }
}
