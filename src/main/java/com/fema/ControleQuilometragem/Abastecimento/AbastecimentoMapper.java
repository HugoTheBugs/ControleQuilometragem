package com.fema.ControleQuilometragem.Abastecimento;

import org.springframework.stereotype.Component;

@Component
public class AbastecimentoMapper {

    public AbastecimentoModel map(AbastecimentoDTO abastecimentoDTO){
        AbastecimentoModel abastecimentoModel = new AbastecimentoModel();
        abastecimentoModel.setId(abastecimentoDTO.getId());
        abastecimentoModel.setPosto(abastecimentoDTO.getPosto());
        abastecimentoModel.setMotorista(abastecimentoDTO.getMotorista());
        abastecimentoModel.setVeiculo(abastecimentoDTO.getVeiculo());
        abastecimentoModel.setCombustivel(abastecimentoDTO.getCombustivel());
        abastecimentoModel.setData(abastecimentoDTO.getData());
        abastecimentoModel.setKmAtual(abastecimentoDTO.getKmAtual());
        abastecimentoModel.setLitros(abastecimentoDTO.getLitros());
        abastecimentoModel.setValorTotal(abastecimentoDTO.getValorTotal());

        return abastecimentoModel;
    }

    public AbastecimentoDTO map(AbastecimentoModel abastecimentoModel){
        AbastecimentoDTO abastecimentoDTO = new AbastecimentoDTO();
        abastecimentoDTO.setId(abastecimentoModel.getId());
        abastecimentoDTO.setPosto(abastecimentoModel.getPosto());
        abastecimentoDTO.setMotorista(abastecimentoModel.getMotorista());
        abastecimentoDTO.setVeiculo(abastecimentoModel.getVeiculo());
        abastecimentoDTO.setCombustivel(abastecimentoModel.getCombustivel());
        abastecimentoDTO.setData(abastecimentoModel.getData());
        abastecimentoDTO.setKmAtual(abastecimentoModel.getKmAtual());
        abastecimentoDTO.setLitros(abastecimentoModel.getLitros());
        abastecimentoDTO.setValorTotal(abastecimentoModel.getValorTotal());

        return abastecimentoDTO;
    }
}
