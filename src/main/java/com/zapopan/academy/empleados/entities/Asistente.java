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
    
    @Column(unique = true)
    private String curp;

    @Column
    private String nombre ;

    @Column
    private String apellidoMaterno;

    @Column
    private String apellidoPaterno;
 
    @Column 
    private String sexo;
    
    @Column 
    private String calle;

    @Column 
    private String numeroExt;

    @Column 
    private String numeroInt;

    @Column 
    private String codigo;

    @Column 
    private String colonia;

    @Column 
    private String municipio;

    @Column 
    private String estado;

    @Column 
    private String telefonoCasa;

    @Column 
    private String telefonoCelular;
         
    
    @ManyToMany (mappedBy = "asistentes")
    private List <Evento> eventos;

    @ManyToOne
    @JoinColumn
    private Estatus status;


}