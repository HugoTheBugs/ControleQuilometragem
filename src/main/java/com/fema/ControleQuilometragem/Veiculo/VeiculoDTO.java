package com.fema.ControleQuilometragem.Veiculo;

import com.fema.ControleQuilometragem.Combustivel.CombustivelModel;
import com.fema.ControleQuilometragem.Marca.MarcaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private Long id;
    private String placa;
    private String modelo;
    private int ano;
    private float tanqueCapacidade;
    private String categoria;
    private String status;
    private MarcaModel marca;
    private CombustivelModel combustivel;

}