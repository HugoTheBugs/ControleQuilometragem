package com.fema.ControleQuilometragem.Marca;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_marca")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name="nome")
    private String nome;

}