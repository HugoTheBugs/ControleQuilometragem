package com.fema.ControleQuilometragem.Combustivel;

import org.springframework.stereotype.Service;

@Service
public class CombustivelService {
    private CombustivelRepository combustivelRepository;
    private CombustivelMapper combustivelMapper;

    public CombustivelService(CombustivelRepository combustivelRepository, CombustivelMapper combustivelMapper){
        this.combustivelRepository = combustivelRepository;
        this.combustivelMapper = combustivelMapper;
    }

    //Criar novo combustivel

    //Listar combustiveis

}