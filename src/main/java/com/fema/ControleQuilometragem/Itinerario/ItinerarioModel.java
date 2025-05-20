package com.fema.ControleQuilometragem.Itinerario;

import com.fema.ControleQuilometragem.Cliente.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_itinerario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItinerarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

}
