package com.fema.ControleQuilometragem.Marca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/marcas/ui")
public class MarcaControllerUi {
    private MarcaService marcaService;

    public MarcaControllerUi(MarcaService marcaService){
        this.marcaService = marcaService;
    }

    @GetMapping("/listar")
    public String listarMarcas(Model model){
        List<MarcaDTO> marcas = marcaService.listarMarcas();
        model.addAttribute("marcas", marcas);
        return "listarMarcas";
    }

    // Deletar Marca
    @GetMapping("/deletar/{id}")
    public String deletarMarcaPorId(@PathVariable Long id){
        marcaService.deletarMarcaPorId(id);
        return "redirect:/marcas/ui/listar";
    }
}
