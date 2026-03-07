/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.service;

import com.cafeteria.domain.Venta;
import java.util.List;

public interface VentaService {

    List<Venta> getVentas();

    void save(Venta venta);

}
