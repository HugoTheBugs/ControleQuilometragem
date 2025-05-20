package com.fema.ControleQuilometragem.Itinerario;

import org.springframework.stereotype.Service;

import java.util.List;
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
}
