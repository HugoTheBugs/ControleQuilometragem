package com.fema.ControleQuilometragem.Marca;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // Listar Marcas por ID
    public MarcaDTO listarMarcasPorId(Long id){
        Optional<MarcaModel> marcaPorId = marcaRepository.findById(id);
        return marcaPorId.map(marcaMapper::map).orElse(null);
    }

    // Deletar uma marca
    public void deletarMarcaPorId(Long id){
        marcaRepository.deleteById(id);
    }

    // Atualizar a Marca
    public MarcaDTO atualizarMarca(Long id, MarcaDTO marcaDTO){
        Optional<MarcaModel> marcaExistente = marcaRepository.findById(id);
        if(marcaExistente.isPresent()){
            MarcaModel marcaAtualizado = marcaMapper.map(marcaDTO);
            marcaAtualizado.setId(id);
            MarcaModel marcaSalvo = marcaRepository.save(marcaAtualizado);
            return marcaMapper.map(marcaSalvo);
        }
        return null;
    }

}