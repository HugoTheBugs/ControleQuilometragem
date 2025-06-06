package com.fema.ControleQuilometragem.Marca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService){
        this.marcaService = marcaService;
    }

    //Adicionar Marca
    @PostMapping("/criar")
    public ResponseEntity<String> criarMarca(@RequestBody MarcaDTO marca){
        MarcaDTO novaMarca = marcaService.criarMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Marca criada com sucesso: " + novaMarca.getNome() + " (ID): " + novaMarca.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MarcaDTO>> listarMarcas(){
        List<MarcaDTO> marcas = marcaService.listarMarcas();
        return ResponseEntity.ok(marcas);
    }

    // Mostrar marca por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarMarcasPorId(@PathVariable Long id){

        MarcaDTO marca = marcaService.listarMarcasPorId(id);
        if(marca != null){
            return ResponseEntity.ok(marca);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Marca com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Marca
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMarcaPorId(@PathVariable Long id){
        if(marcaService.listarMarcasPorId(id) !=null){
            marcaService.deletarMarcaPorId(id);
            return ResponseEntity.ok("Marca com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A marca com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados das Marcas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMarcaPorId(@PathVariable Long id, @RequestBody MarcaDTO marcaAtualizado){
        MarcaDTO marca = marcaService.atualizarMarca(id, marcaAtualizado);

        if(marca != null){
            return ResponseEntity.ok(marca);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Marca com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
