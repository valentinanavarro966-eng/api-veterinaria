package com.example.veterinariaJPA.Repository;

import com.example.veterinariaJPA.Model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
}
