package com.example.veterinariaJPA.Repository;

import com.example.veterinariaJPA.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    List<Mascota>findByClienteId(Integer id);
}
