package com.fema.ControleQuilometragem.Posto;

import com.fema.ControleQuilometragem.Posto.PostoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postos")
public class PostoController {

    private final PostoService postoService;

    public PostoController(PostoService postoService){
        this.postoService = postoService;
    }

    //Adicionar Posto
    @PostMapping("/criar")
    public ResponseEntity<String> criarPosto(@RequestBody PostoDTO posto){
        PostoDTO novoPosto = postoService.criarPosto(posto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Posto criado com sucesso: " + novoPosto.getNome() + " (ID): " + novoPosto.getId());
    }

    //Mostrar todos os Postos
    @GetMapping("/listar")
    public ResponseEntity<List<PostoDTO>> listarPostos(){
        List<PostoDTO> postos = postoService.listarPostos();
        return ResponseEntity.ok(postos);
    }

    // Mostrar posto por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarPostosPorId(@PathVariable Long id){

        PostoDTO posto = postoService.listarPostosPorId(id);
        if(posto != null){
            return ResponseEntity.ok(posto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Posto com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Posto
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPostoPorId(@PathVariable Long id){
        if(postoService.listarPostosPorId(id) !=null){
            postoService.deletarPostoPorId(id);
            return ResponseEntity.ok("Posto com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O posto com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Postos
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPostoPorId(@PathVariable Long id, @RequestBody PostoDTO postoAtualizado){
        PostoDTO posto = postoService.atualizarPosto(id, postoAtualizado);

        if(posto != null){
            return ResponseEntity.ok(posto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Posto com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
