package com.notas.Repositorios;

import com.notas.Modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Integer> {
    @Query(value = "SELECT * FROM nota WHERE archivada = false", nativeQuery = true)
    List<Nota> findAllActivas();

    @Query(value = "SELECT * FROM nota WHERE archivada = true", nativeQuery = true)
    List<Nota> findAllArchivadas();
}
