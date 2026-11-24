package com.example.veterinariaJPA.Repository;

import com.example.veterinariaJPA.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
