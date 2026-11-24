package com.example.veterinariaJPA.Repository;
import com.example.veterinariaJPA.Model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface TurnoRepository extends JpaRepository<Turno, Integer> {
 List<Turno>findByVeterinarioId(Integer id);
}