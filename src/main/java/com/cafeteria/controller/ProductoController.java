package com.cafeteria.controller;

import com.cafeteria.domain.Producto;
import com.cafeteria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto/listado")
    public String listado(Model model) {

        var productos = productoService.getProductos();

        model.addAttribute("productos", productos);

        return "producto/listado";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto) {
        return "producto/modifica";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {

        productoService.save(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto) {

        productoService.delete(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {

        producto = productoService.getProducto(producto);

        model.addAttribute("producto", producto);

        return "producto/modifica";
    }

}
