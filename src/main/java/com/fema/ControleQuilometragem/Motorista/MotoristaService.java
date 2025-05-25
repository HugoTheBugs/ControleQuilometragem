package com.fema.ControleQuilometragem.Motorista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    public MotoristaRepository motoristaRepository;
    public MotoristaMapper motoristaMapper;

    public MotoristaService(MotoristaRepository motoristaRepository, MotoristaMapper motoristaMapper){
        this.motoristaRepository = motoristaRepository;
        this.motoristaMapper = motoristaMapper;
    }

    //Criar novo motorista
    public MotoristaDTO criarMotorista(MotoristaDTO motoristaDTO){
        MotoristaModel motorista = motoristaMapper.map(motoristaDTO);
        motorista = motoristaRepository.save(motorista);
        return motoristaMapper.map(motorista);
    }

    //Listar Motoristas
    public List<MotoristaDTO> listarMotoristas(){
        List<MotoristaModel> motoristas = motoristaRepository.findAll();
        return motoristas.stream()
                .map(motoristaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar Motoristas por ID
    public MotoristaDTO listarMotoristasPorId(Long id){
        Optional<MotoristaModel> motoristaPorId = motoristaRepository.findById(id);
        return motoristaPorId.map(motoristaMapper::map).orElse(null);
    }

    // Deletar um motorista
    public void deletarMotoristaPorId(Long id){
        motoristaRepository.deleteById(id);
    }

    // Atualizar Motorista
    public MotoristaDTO atualizarMotorista(Long id, MotoristaDTO motoristaDTO){
        Optional<MotoristaModel> motoristaExistente = motoristaRepository.findById(id);
        if(motoristaExistente.isPresent()){
            MotoristaModel motoristaAtualizado = motoristaMapper.map(motoristaDTO);
            motoristaAtualizado.setId(id);
            MotoristaModel motoristaSalvo = motoristaRepository.save(motoristaAtualizado);
            return motoristaMapper.map(motoristaSalvo);
        }
        return null;
    }

}
