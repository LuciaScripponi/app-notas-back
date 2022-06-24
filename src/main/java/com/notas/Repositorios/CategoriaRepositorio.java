package com.notas.Repositorios;

import com.notas.Modelos.Categoria;
import com.notas.Modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {
    @Query(value = "SELECT DISTINCT categoria FROM categoria", nativeQuery = true)
    List<String> findCategoriasUnicas();
}

