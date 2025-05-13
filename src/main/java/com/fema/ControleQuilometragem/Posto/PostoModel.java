package com.fema.ControleQuilometragem.Posto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_posto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "id")
        private Long id;

        @Column (name = "nome")
        private String nome;

        @Column (name = "cidade")
        private String cidade;

        @Column (name = "estado")
        private String estado;
}
