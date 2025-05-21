package com.fema.ControleQuilometragem.Movimentacao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final MovimentacaoMapper movimentacaoMapper;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, MovimentacaoMapper movimentacaoMapper){
        this.movimentacaoRepository = movimentacaoRepository;
        this.movimentacaoMapper = movimentacaoMapper;
    }

    //Realizar Movimentacao
    public MovimentacaoDTO criarMovimentacao(MovimentacaoDTO movimentacaoDTO){
        MovimentacaoModel movimentacao = movimentacaoMapper.map(movimentacaoDTO);
        movimentacao = movimentacaoRepository.save(movimentacao);
        return movimentacaoMapper.map(movimentacao);
    }

    //Listar Movimentação
    public List<MovimentacaoDTO> listarMovimentacao(){
        List<MovimentacaoModel> movimentacao = movimentacaoRepository.findAll();
        return movimentacao.stream()
                .map(movimentacaoMapper::map)
                .collect(Collectors.toList());
    }

}
