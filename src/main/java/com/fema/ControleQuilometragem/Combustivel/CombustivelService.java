package com.fema.ControleQuilometragem.Combustivel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombustivelService {
    private CombustivelRepository combustivelRepository;
    private CombustivelMapper combustivelMapper;

    public CombustivelService(CombustivelRepository combustivelRepository, CombustivelMapper combustivelMapper){
        this.combustivelRepository = combustivelRepository;
        this.combustivelMapper = combustivelMapper;
    }

    //Criar novo combustivel
    public CombustivelDTO criarCombustivel(CombustivelDTO combustivelDTO){
        CombustivelModel combustivel = combustivelMapper.map(combustivelDTO);
        combustivel = combustivelRepository.save(combustivel);
        return combustivelMapper.map(combustivel);
    }

    //Listar combustiveis
    public List<CombustivelDTO> listarCombustiveis(){
        List<CombustivelModel> combustiveis = combustivelRepository.findAll();
        return combustiveis.stream()
                .map(combustivelMapper::map)
                .collect(Collectors.toList());
    }
}