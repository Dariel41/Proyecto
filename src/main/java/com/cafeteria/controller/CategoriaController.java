package com.cafeteria.controller;

import com.cafeteria.domain.Categoria;
import com.cafeteria.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {

        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);

        return "categoria/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Categoria categoria) {
        return "categoria/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {

        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(id);

        categoriaService.delete(categoria);

        return "redirect:/categoria/listado";
    }
}
