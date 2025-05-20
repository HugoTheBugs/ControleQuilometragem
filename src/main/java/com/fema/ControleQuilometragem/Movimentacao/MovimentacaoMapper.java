package com.fema.ControleQuilometragem.Movimentacao;

import org.springframework.stereotype.Component;

@Component
public class MovimentacaoMapper {

    public MovimentacaoModel map(MovimentacaoDTO movimentacaoDTO){
        MovimentacaoModel movimentacaoModel = new MovimentacaoModel();
        movimentacaoModel.setId(movimentacaoDTO.getId());
        movimentacaoModel.setData(movimentacaoDTO.getData());
        movimentacaoModel.setVeiculo(movimentacaoDTO.getVeiculo());
        movimentacaoModel.setMotorista(movimentacaoDTO.getMotorista());
        movimentacaoModel.setItinerario(movimentacaoDTO.getItinerario());
        movimentacaoModel.setKmInicial(movimentacaoDTO.getKmInicial());
        movimentacaoModel.setKmFinal(movimentacaoDTO.getKmFinal());

        return movimentacaoModel;
    }

    public MovimentacaoDTO map(MovimentacaoModel movimentacaoModel){
        MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
        movimentacaoDTO.setId(movimentacaoModel.getId());
        movimentacaoDTO.setData(movimentacaoModel.getData());
        movimentacaoDTO.setVeiculo(movimentacaoModel.getVeiculo());
        movimentacaoDTO.setMotorista(movimentacaoModel.getMotorista());
        movimentacaoDTO.setItinerario(movimentacaoModel.getItinerario());
        movimentacaoDTO.setKmInicial(movimentacaoModel.getKmInicial());
        movimentacaoDTO.setKmFinal(movimentacaoModel.getKmFinal());

        return movimentacaoDTO;
    }

}
