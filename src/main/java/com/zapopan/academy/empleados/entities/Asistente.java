package com.zapopan.academy.empleados.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Asistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String Nombre ;

    @Column
    private String Apellido_materno;

    @Column
    private String Apellido_paterno;
 
    @Column(unique = true)
    private String curp;



    // Como le haria para importar las columnas directamente del excel
    
    
    @ManyToMany (mappedBy = "asistentes")
    private List <Evento> eventos;

    @ManyToOne
    @JoinColumn
    private Estatus status;


}