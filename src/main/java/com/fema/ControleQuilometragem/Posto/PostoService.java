package com.fema.ControleQuilometragem.Posto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // Listar Postos por ID
    public PostoDTO listarPostosPorId(Long id){
        Optional<PostoModel> postoPorId = postoRepository.findById(id);
        return postoPorId.map(postoMapper::map).orElse(null);
    }

    // Deletar um posto
    public void deletarPostoPorId(Long id){
        postoRepository.deleteById(id);
    }

    // Atualizar Posto
    public PostoDTO atualizarPosto(Long id, PostoDTO postoDTO){
        Optional<PostoModel> postoExistente = postoRepository.findById(id);
        if(postoExistente.isPresent()){
            PostoModel postoAtualizado = postoMapper.map(postoDTO);
            postoAtualizado.setId(id);
            PostoModel postoSalvo = postoRepository.save(postoAtualizado);
            return postoMapper.map(postoSalvo);
        }
        return null;
    }
}