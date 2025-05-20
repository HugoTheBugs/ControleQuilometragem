package com.fema.ControleQuilometragem.Movimentacao;

import com.fema.ControleQuilometragem.Itinerario.ItinerarioModel;
import com.fema.ControleQuilometragem.Motorista.MotoristaModel;
import com.fema.ControleQuilometragem.Veiculo.VeiculoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {

    private Long id;
    private LocalDate data;
    private VeiculoModel veiculo;
    private MotoristaModel motorista;
    private ItinerarioModel itinerario;
    private float kmInicial;
    private float kmFinal;
}
