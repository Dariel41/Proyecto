/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.service.impl;

import com.cafeteria.domain.Venta;
import com.cafeteria.repository.VentaRepository;
import com.cafeteria.service.VentaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void save(Venta venta) {
        ventaRepository.save(venta);
    }
}
