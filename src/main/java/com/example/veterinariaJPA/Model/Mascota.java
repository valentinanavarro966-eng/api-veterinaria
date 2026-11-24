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
@Table(name= "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer id;

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private double peso;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
