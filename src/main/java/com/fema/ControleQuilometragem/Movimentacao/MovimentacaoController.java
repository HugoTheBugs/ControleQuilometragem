package com.fema.ControleQuilometragem.Movimentacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService){
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarLancamento(@RequestBody MovimentacaoDTO movimentacao){
        MovimentacaoDTO novaMovimentacao = movimentacaoService.criarMovimentacao(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Movimentação criada com sucesso, (ID): " + novaMovimentacao.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimentacaoDTO>> listarMovimentacao(){
        List<MovimentacaoDTO> movimentacao = movimentacaoService.listarMovimentacao();
        return ResponseEntity.ok(movimentacao);
    }
}
