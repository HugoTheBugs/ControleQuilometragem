package com.fema.ControleQuilometragem.Veiculo;

import com.fema.ControleQuilometragem.Combustivel.CombustivelModel;
import com.fema.ControleQuilometragem.Marca.MarcaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private int ano;

    @Column(name = "tanque_capacidade")
    private float tanqueCapacidade;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaModel marca;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private CombustivelModel combustivel;

}