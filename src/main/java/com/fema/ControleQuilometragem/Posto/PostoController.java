package com.fema.ControleQuilometragem.Posto;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postos")
public class PostoController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }
}
