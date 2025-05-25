package com.fema.ControleQuilometragem.Movimentacao;

import com.fema.ControleQuilometragem.Movimentacao.MovimentacaoDTO;
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

    // Mostrar movimentacao por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarMovimentacaoPorId(@PathVariable Long id){

        MovimentacaoDTO movimentacao = movimentacaoService.listarMovimentacaoPorId(id);
        if(movimentacao != null){
            return ResponseEntity.ok(movimentacao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Movimentacao com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Movimentacao
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMovimentacaoPorId(@PathVariable Long id){
        if(movimentacaoService.listarMovimentacaoPorId(id) !=null){
            movimentacaoService.deletarMovimentacaoPorId(id);
            return ResponseEntity.ok("Movimentacao com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A movimentacao com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados das Movimentacaos
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMovimentacaoPorId(@PathVariable Long id, @RequestBody MovimentacaoDTO movimentacaoAtualizado){
        MovimentacaoDTO movimentacao = movimentacaoService.atualizarMovimentacao(id, movimentacaoAtualizado);

        if(movimentacao != null){
            return ResponseEntity.ok(movimentacao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Movimentacao com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
