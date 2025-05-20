package com.fema.ControleQuilometragem.Motorista;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaDTO {

    private Long id;
    private String nome;
    private String cnh;
    private String cnh_categoria;
    private LocalDate cnh_vencimento;
    private String telefone;
    private String status;

}
