package com.fema.ControleQuilometragem.Movimentacao;

import com.fema.ControleQuilometragem.Itinerario.ItinerarioModel;
import com.fema.ControleQuilometragem.Motorista.MotoristaModel;
import com.fema.ControleQuilometragem.Veiculo.VeiculoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_movimentacao")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovimentacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private MotoristaModel motorista;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    private ItinerarioModel itinerario;

    @Column(name = "km_inicial")
    private float kmInicial;

    @Column(name = "km_final")
    private float kmFinal;
}
