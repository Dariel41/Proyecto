/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.controller;

import com.cafeteria.domain.Producto;
import com.cafeteria.repository.VentaRepository;
import com.cafeteria.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VentaController {

    private final VentaRepository ventaRepository;
    private final ProductoService productoService;

    public VentaController(VentaRepository ventaRepository, ProductoService productoService) {
        this.ventaRepository = ventaRepository;
        this.productoService = productoService;
    }

    @GetMapping("/ventas/listado")
    public String listado(Model model) {

        var ventas = ventaRepository.findAll();
        model.addAttribute("ventas", ventas);

        return "ventas/listado";
    }

    /* PANTALLA PARA COMPRAR */
    @GetMapping("/ventas/comprar/{idProducto}")
    public String comprarProducto(Producto producto, Model model) {

        producto = productoService.getProducto(producto);

        model.addAttribute("producto", producto);

        return "ventas/comprar";
    }

    /* CONFIRMAR COMPRA */
    @PostMapping("/ventas/confirmar")
    public String confirmarCompra(Long idProducto, int cantidad, Model model) {

        Producto producto = new Producto();
        producto.setIdProducto(idProducto);

        producto = productoService.getProducto(producto);

        String mensaje = "¡Compra realizada con éxito!";

        model.addAttribute("producto", producto);
        model.addAttribute("mensaje", mensaje);

        return "ventas/comprar";
    }

}
