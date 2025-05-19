package com.fema.ControleQuilometragem.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
}
