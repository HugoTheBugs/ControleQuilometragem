package com.fema.ControleQuilometragem.Combustivel;

import com.fema.ControleQuilometragem.Combustivel.CombustivelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustiveis")
public class CombustivelController {

    private final CombustivelService combustivelService;

    public CombustivelController(CombustivelService combustivelService){
        this.combustivelService = combustivelService;
    }

    //Adicionar combustível
    @PostMapping("/criar")
    public ResponseEntity<String> criarCombustivel(@RequestBody CombustivelDTO combuustivel){
        CombustivelDTO novoCombustivel = combustivelService.criarCombustivel(combuustivel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Combustível criado com sucesso: " + novoCombustivel.getNome() + " (ID): " + novoCombustivel.getId());
    }

    //Lista os combustíveis
    @GetMapping("/listar")
    public ResponseEntity<List<CombustivelDTO>> listarCombustiveis(){
        List<CombustivelDTO> combustiveis = combustivelService.listarCombustiveis();
        return ResponseEntity.ok(combustiveis);
    }

    // Mostrar combustivel por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarCombustiveisPorId(@PathVariable Long id){

        CombustivelDTO combustivel = combustivelService.listarCombustiveisPorId(id);
        if(combustivel != null){
            return ResponseEntity.ok(combustivel);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Combustivel com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Combustivel
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCombustivelPorId(@PathVariable Long id){
        if(combustivelService.listarCombustiveisPorId(id) !=null){
            combustivelService.deletarCombustivelPorId(id);
            return ResponseEntity.ok("Combustivel com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O combustivel com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Combustivels
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCombustivelPorId(@PathVariable Long id, @RequestBody CombustivelDTO combustivelAtualizado){
        CombustivelDTO combustivel = combustivelService.atualizarCombustivel(id, combustivelAtualizado);

        if(combustivel != null){
            return ResponseEntity.ok(combustivel);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Combustivel com o id: " + id + " não existe nos nossos registros!");
        }
    }

}
