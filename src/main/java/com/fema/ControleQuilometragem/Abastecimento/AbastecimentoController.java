package com.fema.ControleQuilometragem.Abastecimento;

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
}
