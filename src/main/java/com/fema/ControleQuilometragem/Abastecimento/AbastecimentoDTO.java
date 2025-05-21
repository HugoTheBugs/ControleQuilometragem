package com.fema.ControleQuilometragem.Abastecimento;

import com.fema.ControleQuilometragem.Combustivel.CombustivelModel;
import com.fema.ControleQuilometragem.Motorista.MotoristaModel;
import com.fema.ControleQuilometragem.Posto.PostoModel;
import com.fema.ControleQuilometragem.Veiculo.VeiculoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbastecimentoDTO {

    private Long id;
    private PostoModel posto;
    private MotoristaModel motorista;
    private VeiculoModel veiculo;
    private CombustivelModel combustivel;
    private LocalDate data;
    private float kmAtual;
    private float litros;
    private float valorTotal;

}
