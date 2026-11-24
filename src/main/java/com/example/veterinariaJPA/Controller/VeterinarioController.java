package com.example.veterinariaJPA.Controller;

import com.example.veterinariaJPA.Model.Veterinario;
import com.example.veterinariaJPA.Repository.VeterinarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {
    private VeterinarioRepository veterinarioRepository;

    public VeterinarioController(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @GetMapping
    public List<Veterinario> listarVeterinarios ()
    {
        return veterinarioRepository.findAll();
    }
    // http://localhost:8080/veterinarios

    @GetMapping("/{id}")
    public Veterinario buscarVeterinarioXid (@PathVariable Integer id)
    {
        return veterinarioRepository.findById(id).orElse(null);
    }
    // http://localhost:8080/veterinarios/x

    @PostMapping
    public Veterinario crearVeterinario (@RequestBody Veterinario veterinario)
    {
        return veterinarioRepository.save(veterinario);
    }
    // http://localhost:8080/veterinarios

    @PutMapping("/{id}")
    public Veterinario modificarVeterinario (@PathVariable Integer id, @RequestBody Veterinario veterinario)
    {
        Veterinario veterinarioAmodificar = veterinarioRepository.findById(id).orElseThrow();
        veterinarioAmodificar.setNombre(veterinario.getNombre());
        veterinarioAmodificar.setApellido(veterinario.getApellido());
        veterinarioAmodificar.setEmail(veterinario.getEmail());
        veterinarioAmodificar.setEspecialidad(veterinario.getEspecialidad());
        veterinarioAmodificar.setMatricula(veterinario.getMatricula());
        veterinarioAmodificar.setTelefono(veterinario.getTelefono());

        return veterinarioRepository.save(veterinarioAmodificar);
    }
    // http://localhost:8080/veterinarios/x
}
