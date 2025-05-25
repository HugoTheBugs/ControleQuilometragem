package com.fema.ControleQuilometragem.Itinerario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItinerarioService {

    private final ItinerarioRepository itinerarioRepository;
    private final ItinerarioMapper itinerarioMapper;

    public ItinerarioService(ItinerarioRepository itinerarioRepository, ItinerarioMapper itinerarioMapper){
        this.itinerarioRepository = itinerarioRepository;
        this.itinerarioMapper = itinerarioMapper;
    }

    //Criar Novo Itinerário
    public ItinerarioDTO criarItinerario(ItinerarioDTO itinerarioDTO){
        ItinerarioModel itinerario = itinerarioMapper.map(itinerarioDTO);
        itinerario = itinerarioRepository.save(itinerario);
        return itinerarioMapper.map(itinerario);
    }

    //Listar todos os Itinerarios
    public List<ItinerarioDTO> listarItinerarios(){
        List<ItinerarioModel> itinerarios = itinerarioRepository.findAll();
        return itinerarios.stream()
                .map(itinerarioMapper::map)
                .collect(Collectors.toList());
    }
    // Listar Itinerarios por ID
    public ItinerarioDTO listarItinerariosPorId(Long id){
        Optional<ItinerarioModel> itinerarioPorId = itinerarioRepository.findById(id);
        return itinerarioPorId.map(itinerarioMapper::map).orElse(null);
    }

    // Deletar um itinerario
    public void deletarItinerarioPorId(Long id){
        itinerarioRepository.deleteById(id);
    }

    // Atualizar Itinerario
    public ItinerarioDTO atualizarItinerario(Long id, ItinerarioDTO itinerarioDTO){
        Optional<ItinerarioModel> itinerarioExistente = itinerarioRepository.findById(id);
        if(itinerarioExistente.isPresent()){
            ItinerarioModel itinerarioAtualizado = itinerarioMapper.map(itinerarioDTO);
            itinerarioAtualizado.setId(id);
            ItinerarioModel itinerarioSalvo = itinerarioRepository.save(itinerarioAtualizado);
            return itinerarioMapper.map(itinerarioSalvo);
        }
        return null;
    }
    
}
