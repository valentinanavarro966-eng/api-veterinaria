package com.example.veterinariaJPA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "veterinaria")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinaria")
    private Integer id;

    private String nombre;
    private String apellido;
    private int matricula;
    private String especialidad;
    private String telefono;
    private String email;

}
