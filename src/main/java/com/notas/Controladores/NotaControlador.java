package com.notas.Controladores;

import com.notas.Modelos.Nota;
import com.notas.Servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NotaControlador {
    @Autowired
    NotaServicio notaServicio;

    @GetMapping("/notasActivas")
    public List<Nota> mostrarNotasActivas(){
        return notaServicio.mostrarNotasActivas();
    }

    @GetMapping("/notasArchivadas")
    public List<Nota> mostrarNotasArchivadas(){
        return notaServicio.mostrarNotasArchivadas();
    }

    @GetMapping("/notaxid/{id}")
    public Optional<Nota> mostrarNotaXid(@PathVariable("id") int id){
        return notaServicio.mostrarNotaXid(id);
    }

    @PostMapping("/agregarNota")
    public Nota agregarNota(@RequestBody Nota nota){
        return notaServicio.guardarNota(nota);
    }

    @DeleteMapping("/eliminarNota/{id}")
    public void eliminarNota(@PathVariable("id") int id){
        notaServicio.eliminarNota(id);
    }

    @PutMapping("/modificarNota")
    public Nota modificarNota(@RequestBody Nota nota){
        return notaServicio.modificarNota(nota);
    }

    @DeleteMapping("/archivarNota/{id}")
    public void archivarNota(@PathVariable("id") int id){
        notaServicio.archivarNota(id);
    }

    @DeleteMapping("/desarchivarNota/{id}")
    public void desarchivarNota(@PathVariable("id") int id){
        notaServicio.desarchivarNota(id);
    }
}
