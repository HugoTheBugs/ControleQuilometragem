package com.fema.ControleQuilometragem.Motorista;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_motorista")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MotoristaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnh")
    private String cnh;

    @Column(name = "cnh_categoria")
    private String cnh_categoria;

    @Column(name = "cnh_vencimento")
    private LocalDate cnh_vencimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "status")
    private String status;
}
