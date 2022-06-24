package com.notas.Servicios;

import com.notas.Modelos.Nota;
import com.notas.Repositorios.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotaServicio {
    @Autowired
    NotaRepositorio notaRepositorio;

    public List<Nota> mostrarNotasActivas(){
        return notaRepositorio.findAllActivas();
    }

    public List<Nota> mostrarNotasArchivadas(){
        return notaRepositorio.findAllArchivadas();
    }

    public Optional<Nota> mostrarNotaXid(int id){
        return notaRepositorio.findById(id);
    }

    public Nota guardarNota(Nota nota){
        return notaRepositorio.save(nota);
    }

    public void eliminarNota(int id){
        notaRepositorio.deleteById(id);
    }

    public Nota modificarNota(Nota nota){
        return notaRepositorio.save(nota);
    }

    public void archivarNota(int id){
        Optional<Nota> nota = notaRepositorio.findById(id);
        nota.get().setArchivada(true);
        notaRepositorio.save(nota.get());
    }
    public void desarchivarNota(int id){
        Optional<Nota> nota = notaRepositorio.findById(id);
        nota.get().setArchivada(false);
        notaRepositorio.save(nota.get());
    }
}
