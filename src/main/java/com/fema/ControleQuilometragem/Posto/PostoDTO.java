package com.fema.ControleQuilometragem.Posto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostoDTO {

        private Long id;
        private String nome;
        private String cidade;
        private String estado;
}
