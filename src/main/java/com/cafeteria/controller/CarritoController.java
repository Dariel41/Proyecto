/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.controller;

import com.cafeteria.domain.Producto;
import com.cafeteria.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarritoController {

    private final ProductoService productoService;

    private List<Producto> carrito = new ArrayList<>();

    public CarritoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/carrito/agregar/{idProducto}")
    public String agregar(@PathVariable Long idProducto) {

        Producto producto = productoService.getProducto(new Producto(idProducto));

        carrito.add(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("/carrito/ver")
    public String verCarrito(Model model) {

        model.addAttribute("carrito", carrito);

        return "carrito/listado";
    }

    @GetMapping("/carrito/comprar")
    public String comprar() {

        carrito.clear();

        return "redirect:/producto/listado";
    }

}
