package com.notas.Servicios;

import com.notas.Modelos.Categoria;
import com.notas.Repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> mostrarCategorias(){
        return categoriaRepositorio.findAll();
    }

    public List<String> mostrarCategoriasUnicas(){
        return categoriaRepositorio.findCategoriasUnicas();
    }

    public Optional<Categoria> mostrarCategoriaXid(int id){
        return categoriaRepositorio.findById(id);
    }

    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    public Categoria modificarCategoria(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    public void eliminarCategoria(int id){
        categoriaRepositorio.deleteById(id);
    }
}
