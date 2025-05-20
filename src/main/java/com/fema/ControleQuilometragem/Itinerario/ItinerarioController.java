package com.fema.ControleQuilometragem.Itinerario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
