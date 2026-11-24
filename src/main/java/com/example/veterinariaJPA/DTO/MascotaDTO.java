package com.example.veterinariaJPA.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MascotaDTO {

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private double peso;
    private int id_cliente;
}
