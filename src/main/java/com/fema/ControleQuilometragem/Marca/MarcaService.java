package com.fema.ControleQuilometragem.Marca;

import org.springframework.stereotype.Service;

@Service
public class MarcaService {
    public MarcaRepository marcaRepository;
    public MarcaMapper marcaMapper;

    public MarcaService(MarcaRepository marcaRepository, MarcaMapper marcaMapper){
        this.marcaRepository = marcaRepository;
        this.marcaMapper = marcaMapper;
    }

    //Criar nova Marca

    //Listar Marcas
}