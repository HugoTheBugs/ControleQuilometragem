package com.fema.ControleQuilometragem.Motorista;

import org.springframework.stereotype.Service;

import java.util.List;
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

}
