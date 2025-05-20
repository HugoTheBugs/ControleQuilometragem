package com.fema.ControleQuilometragem.Motorista;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("motoristas/")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService){
        this.motoristaService = motoristaService;
    }

    //Adicionar Motorista
    @PostMapping("/criar")
    public ResponseEntity<String> criarMotorista(@RequestBody MotoristaDTO motorista){
        MotoristaDTO novoMotorista = motoristaService.criarMotorista(motorista);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Motorista criado com sucesso: " + novoMotorista.getNome() + " (ID): " + novoMotorista.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MotoristaDTO>> listarMotoristas(){
        List<MotoristaDTO> motoristas = motoristaService.listarMotoristas();
        return ResponseEntity.ok(motoristas);
    }
}
