package com.fema.ControleQuilometragem.Itinerario;

import com.fema.ControleQuilometragem.Itinerario.ItinerarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itinerarios")
public class ItinerarioController {

    private final ItinerarioService itinerarioService;

    public ItinerarioController(ItinerarioService itinerarioService){
        this.itinerarioService = itinerarioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarItinerario(@RequestBody ItinerarioDTO itinerario){
        ItinerarioDTO novoItinerario = itinerarioService.criarItinerario(itinerario);
        return ResponseEntity.status((HttpStatus.CREATED))
                .body("Itinerário criado com sucesso: " + novoItinerario.getDescricao() + " (ID): " + novoItinerario.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ItinerarioDTO>> listarItinerarios(){
        List<ItinerarioDTO> itinerarios = itinerarioService.listarItinerarios();
        return ResponseEntity.ok(itinerarios);
    }

    // Mostrar itinerario por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarItinerariosPorId(@PathVariable Long id){

        ItinerarioDTO itinerario = itinerarioService.listarItinerariosPorId(id);
        if(itinerario != null){
            return ResponseEntity.ok(itinerario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Itinerario com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Itinerario
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarItinerarioPorId(@PathVariable Long id){
        if(itinerarioService.listarItinerariosPorId(id) !=null){
            itinerarioService.deletarItinerarioPorId(id);
            return ResponseEntity.ok("Itinerario com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O itinerario com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Itinerarios
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarItinerarioPorId(@PathVariable Long id, @RequestBody ItinerarioDTO itinerarioAtualizado){
        ItinerarioDTO itinerario = itinerarioService.atualizarItinerario(id, itinerarioAtualizado);

        if(itinerario != null){
            return ResponseEntity.ok(itinerario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Itinerario com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
