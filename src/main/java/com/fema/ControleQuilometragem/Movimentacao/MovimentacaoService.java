package com.fema.ControleQuilometragem.Movimentacao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // Listar Movimentacaos por ID
    public MovimentacaoDTO listarMovimentacaoPorId(Long id){
        Optional<MovimentacaoModel> movimentacaoPorId = movimentacaoRepository.findById(id);
        return movimentacaoPorId.map(movimentacaoMapper::map).orElse(null);
    }

    // Deletar um movimentacao
    public void deletarMovimentacaoPorId(Long id){
        movimentacaoRepository.deleteById(id);
    }

    // Atualizar Movimentacao
    public MovimentacaoDTO atualizarMovimentacao(Long id, MovimentacaoDTO movimentacaoDTO){
        Optional<MovimentacaoModel> movimentacaoExistente = movimentacaoRepository.findById(id);
        if(movimentacaoExistente.isPresent()){
            MovimentacaoModel movimentacaoAtualizado = movimentacaoMapper.map(movimentacaoDTO);
            movimentacaoAtualizado.setId(id);
            MovimentacaoModel movimentacaoSalvo = movimentacaoRepository.save(movimentacaoAtualizado);
            return movimentacaoMapper.map(movimentacaoSalvo);
        }
        return null;
    }

}
