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
}
