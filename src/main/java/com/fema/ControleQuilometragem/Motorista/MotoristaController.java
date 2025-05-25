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

    // Mostrar motorista por id
    @GetMapping("/listar/{id}") //path variable
    public ResponseEntity<?> listarMotoristasPorId(@PathVariable Long id){

        MotoristaDTO motorista = motoristaService.listarMotoristasPorId(id);
        if(motorista != null){
            return ResponseEntity.ok(motorista);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Motorista com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // Deletar Motorista
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMotoristaPorId(@PathVariable Long id){
        if(motoristaService.listarMotoristasPorId(id) !=null){
            motoristaService.deletarMotoristaPorId(id);
            return ResponseEntity.ok("Motorista com o ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O motorista com o id " + id + " não encontrado!");
        }
    }

    // Alterar dados dos Motoristas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMotoristaPorId(@PathVariable Long id, @RequestBody MotoristaDTO motoristaAtualizado){
        MotoristaDTO motorista = motoristaService.atualizarMotorista(id, motoristaAtualizado);

        if(motorista != null){
            return ResponseEntity.ok(motorista);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Motorista com o id: " + id + " não existe nos nossos registros!");
        }
    }
}
