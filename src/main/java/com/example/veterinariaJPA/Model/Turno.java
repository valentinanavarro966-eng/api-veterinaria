package com.example.veterinariaJPA.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Integer id;
    private LocalDate fecha;
    private Time hora;
    private String motivo;
    private String estado;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name= "id_veterinaria")
    private Veterinario veterinario;
    @ManyToOne
    @JoinColumn(name="id_mascota")
    private Mascota mascota;

}
