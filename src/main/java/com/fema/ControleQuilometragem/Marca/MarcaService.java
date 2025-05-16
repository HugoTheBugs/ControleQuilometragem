package com.fema.ControleQuilometragem.Marca;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaService {
    public MarcaRepository marcaRepository;
    public MarcaMapper marcaMapper;

    public MarcaService(MarcaRepository marcaRepository, MarcaMapper marcaMapper){
        this.marcaRepository = marcaRepository;
        this.marcaMapper = marcaMapper;
    }

    //Criar nova Marca
    public MarcaDTO criarMarca(MarcaDTO marcaDTO){
        MarcaModel marca = marcaMapper.map(marcaDTO);
        marca = marcaRepository.save(marca);
        return marcaMapper.map(marca);
    }

    //Listar Marcas
    public List<MarcaDTO> listarMarcas(){
        List<MarcaModel> marcas = marcaRepository.findAll();
        return marcas.stream()
                .map(marcaMapper::map)
                .collect(Collectors.toList());
    }
}