package com.notas.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    private String categoria;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference   // Para evitar problemas de recursividad infinita y serializar el objeto
    @JoinTable(name = "nota_categoria",
            joinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"),
            inverseJoinColumns = @JoinColumn(name = "id_nota", referencedColumnName = "id_nota"))
    private List<Nota> notas ;
}
