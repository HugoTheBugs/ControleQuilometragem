package com.fema.ControleQuilometragem.Abastecimento;

import com.fema.ControleQuilometragem.Combustivel.CombustivelModel;
import com.fema.ControleQuilometragem.Motorista.MotoristaModel;
import com.fema.ControleQuilometragem.Posto.PostoModel;
import com.fema.ControleQuilometragem.Veiculo.VeiculoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_abastecimento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbastecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "posto_id")
    private PostoModel posto;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private MotoristaModel motorista;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private CombustivelModel combustivel;

    private LocalDate data;

    @Column(name = "km_atual")
    private float kmAtual;

    private float litros;

    @Column(name = "valor_total")
    private float valorTotal;

}
