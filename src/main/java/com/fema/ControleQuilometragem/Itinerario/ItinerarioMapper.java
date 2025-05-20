package com.fema.ControleQuilometragem.Itinerario;

import org.springframework.stereotype.Component;

@Component
public class ItinerarioMapper {

    public ItinerarioModel map(ItinerarioDTO itinerarioDTO){
        ItinerarioModel itinerarioModel = new ItinerarioModel();
        itinerarioModel.setId(itinerarioDTO.getId());
        itinerarioModel.setDescricao(itinerarioDTO.getDescricao());
        itinerarioModel.setCliente(itinerarioDTO.getCliente());

        return itinerarioModel;
    }

    public ItinerarioDTO map(ItinerarioModel itinerarioModel){
        ItinerarioDTO itinerarioDTO = new ItinerarioDTO();
        itinerarioDTO.setId(itinerarioModel.getId());
        itinerarioDTO.setDescricao(itinerarioModel.getDescricao());
        itinerarioDTO.setCliente(itinerarioModel.getCliente());

        return itinerarioDTO;
    }

}
