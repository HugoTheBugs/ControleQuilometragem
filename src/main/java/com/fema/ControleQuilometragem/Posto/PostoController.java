package com.fema.ControleQuilometragem.Posto;

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

    //Mostrar posto por ID

    //Alterar dados do posto

    //Deletar Posto
}
