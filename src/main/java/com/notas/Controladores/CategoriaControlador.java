package com.notas.Controladores;

import com.notas.Modelos.Categoria;
import com.notas.Servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController
public class CategoriaControlador {
    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/categorias")
    public List<Categoria> mostrarCategorias(){
        return categoriaServicio.mostrarCategorias();
    }
    @GetMapping("/categoriasUnicas")
    public List<String> mostrarCategoriasUnicas(){
        return categoriaServicio.mostrarCategoriasUnicas();
    }
    @GetMapping("/categoriasXid/{id}")
    public Optional<Categoria> mostrarCategoriaXid(@PathVariable("id") int id){
        return categoriaServicio.mostrarCategoriaXid(id);
    }
    @PostMapping("/agregarCategoria")
    public Categoria agregarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.guardarCategoria(categoria);
    }
    @PutMapping("/modificarCategoria")
    public Categoria modificarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.modificarCategoria(categoria);
    }
    @DeleteMapping("/eliminarCategoria/{id}")
    public void eliminarCategoria(@PathVariable("id") int id){
        categoriaServicio.eliminarCategoria(id);
    }
}
