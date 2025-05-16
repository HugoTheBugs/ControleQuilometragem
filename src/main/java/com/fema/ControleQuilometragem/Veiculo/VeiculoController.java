package com.fema.ControleQuilometragem.Veiculo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarVeiculo(@RequestBody VeiculoDTO veiculo){
        VeiculoDTO novoVeiculo = veiculoService.criarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Veículo criado com sucesso: " + novoVeiculo.getModelo() + " (ID): " + novoVeiculo.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos(){
        List<VeiculoDTO> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }
}
