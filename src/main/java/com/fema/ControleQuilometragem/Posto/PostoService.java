package com.fema.ControleQuilometragem.Posto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostoService {

    private final PostoRepository postoRepository;
    private final PostoMapper postoMapper;

    public PostoService(PostoRepository postoRepository, PostoMapper postoMapper){
        this.postoRepository =  postoRepository;
        this.postoMapper = postoMapper;
    }

    //Criar um novo posto
    public PostoDTO criarPosto(PostoDTO postoDTO){
        PostoModel posto = postoMapper.map(postoDTO);
        posto = postoRepository.save(posto);
        return postoMapper.map(posto);
    }

    //Listar todos os postos
    public List<PostoDTO> listarPostos(){
        List<PostoModel> postos = postoRepository.findAll();
        return postos.stream()
                .map(postoMapper::map)
                .collect(Collectors.toList());
    }
}