package com.fema.ControleQuilometragem.Veiculo;

import com.fema.ControleQuilometragem.Veiculo.VeiculoDTO;
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

    // Mostrar veiculo por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarVeiculosPorId(@PathVariable Long id){

        VeiculoDTO veiculo = veiculoService.listarVeiculosPorId(id);
        if(veiculo != null){
            return ResponseEntity.ok(veiculo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Veiculo com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Veiculo
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarVeiculoPorId(@PathVariable Long id){
        if(veiculoService.listarVeiculosPorId(id) !=null){
            veiculoService.deletarVeiculoPorId(id);
            return ResponseEntity.ok("Veiculo com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O veiculo com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Veiculos
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarVeiculoPorId(@PathVariable Long id, @RequestBody VeiculoDTO veiculoAtualizado){
        VeiculoDTO veiculo = veiculoService.atualizarVeiculo(id, veiculoAtualizado);

        if(veiculo != null){
            return ResponseEntity.ok(veiculo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Veiculo com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
