package com.notas.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nota;
    private String titulo;
    private String contenido;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private boolean archivada;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "nota_categoria",
               joinColumns = @JoinColumn(name = "id_nota", referencedColumnName = "id_nota"),
               inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    private List<Categoria> categorias;

    public Nota(String titulo, String contenido, Date fecha, List<Categoria> categorias) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.archivada = false;
        this.categorias = categorias;
    }
}
