package com.fema.ControleQuilometragem.Combustivel;

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

        //Adicionar Veiculo
        @PostMapping("/criar")
        public ResponseEntity<String> criarCombustivel(@RequestBody CombustivelDTO combuustivel){
            CombustivelDTO novoCombustivel = combustivelService.criarCombustivel(combuustivel);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Combustível criado com sucesso: " + novoCombustivel.getNome() + " (ID): " + novoCombustivel.getId());
        }

        //Lista os Veículos
        @GetMapping("/listar")
        public ResponseEntity<List<CombustivelDTO>> listarCombustiveis(){
            List<CombustivelDTO> combustiveis = combustivelService.listarCombustiveis();
            return ResponseEntity.ok(combustiveis);
        }

}
