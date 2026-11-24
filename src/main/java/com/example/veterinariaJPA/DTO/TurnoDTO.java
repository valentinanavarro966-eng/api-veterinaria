package com.example.veterinariaJPA.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class TurnoDTO {

    private LocalDate fecha;
    private Time hora;
    private String motivo;
    private String estado;
    private Integer id_cliente;
    private Integer id_veterinaria;
    private Integer id_mascota;

}
