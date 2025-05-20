package com.fema.ControleQuilometragem.Itinerario;

import com.fema.ControleQuilometragem.Cliente.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItinerarioDTO {

    private Long id;
    private String descricao;
    private ClienteModel cliente;
}
