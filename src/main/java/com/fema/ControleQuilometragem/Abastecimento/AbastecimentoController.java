package com.fema.ControleQuilometragem.Abastecimento;

import com.fema.ControleQuilometragem.Abastecimento.AbastecimentoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService){
        this.abastecimentoService = abastecimentoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarAbastecimento(@RequestBody AbastecimentoDTO abastecimento){
        AbastecimentoDTO novoAbastecimento = abastecimentoService.criarAbastecimento(abastecimento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Abastecimento criado com sucesso, (ID): " + novoAbastecimento.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AbastecimentoDTO>>  listarAbastecimento(){
        List<AbastecimentoDTO> abastecimento = abastecimentoService.listarAbastecimento();
        return ResponseEntity.ok(abastecimento);
    }

    // Mostrar abastecimento por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarAbastecimentosPorId(@PathVariable Long id){

        AbastecimentoDTO abastecimento = abastecimentoService.listarAbastecimentosPorId(id);
        if(abastecimento != null){
            return ResponseEntity.ok(abastecimento);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Abastecimento com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Abastecimento
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAbastecimentoPorId(@PathVariable Long id){
        if(abastecimentoService.listarAbastecimentosPorId(id) !=null){
            abastecimentoService.deletarAbastecimentoPorId(id);
            return ResponseEntity.ok("Abastecimento com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O abastecimento com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Abastecimentos
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarAbastecimentoPorId(@PathVariable Long id, @RequestBody AbastecimentoDTO abastecimentoAtualizado){
        AbastecimentoDTO abastecimento = abastecimentoService.atualizarAbastecimento(id, abastecimentoAtualizado);

        if(abastecimento != null){
            return ResponseEntity.ok(abastecimento);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Abastecimento com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
