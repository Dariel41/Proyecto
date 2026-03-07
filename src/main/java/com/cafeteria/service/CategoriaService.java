package com.cafeteria.service;

import com.cafeteria.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias();

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);

}
