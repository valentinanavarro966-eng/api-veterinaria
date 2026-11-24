package com.example.veterinariaJPA.Controller;

import com.example.veterinariaJPA.DTO.MascotaDTO;
import com.example.veterinariaJPA.Model.Cliente;
import com.example.veterinariaJPA.Model.Mascota;
import com.example.veterinariaJPA.Repository.ClienteRepository;
import com.example.veterinariaJPA.Repository.MascotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    private MascotaRepository mascotaRepository;
    private ClienteRepository clienteRepository;

    public MascotaController(MascotaRepository mascotaRepository, ClienteRepository clienteRepository) {
        this.mascotaRepository = mascotaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Mascota> listarMascotas ()
    {
        return mascotaRepository.findAll();
    }
   // http://localhost:8080/mascotas

    @GetMapping("/{id}")
    public Mascota buscarMascotaXid (@PathVariable Integer id)
    {
        return mascotaRepository.findById(id).orElse(null);
    }
    // http://localhost:8080/mascotas/x

    @PostMapping
    public Mascota crearMascota (@RequestBody MascotaDTO dto)
    {
        Cliente cliente= clienteRepository.findById(dto.getId_cliente()).orElseThrow();

        Mascota mascota=new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setCliente(cliente);

        return mascotaRepository.save(mascota);

    }
    // http://localhost:8080/mascotas

    @PutMapping("/{id}")
    public Mascota modificarMascota (@PathVariable Integer id, @RequestBody MascotaDTO dto)
    {
            Mascota mascota= mascotaRepository.findById(id).orElseThrow();
            mascota.setNombre(dto.getNombre());
            mascota.setEdad(dto.getEdad());
            mascota.setPeso(dto.getPeso());
            mascota.setRaza(dto.getRaza());
            mascota.setEspecie(dto.getEspecie());

            Cliente cliente= clienteRepository.findById(dto.getId_cliente()).orElseThrow();
            mascota.setCliente(cliente);

            return mascotaRepository.save(mascota);
    }
    // http://localhost:8080/mascotas/x

    @GetMapping("/cliente/{idCliente}")
    public List<Mascota> listarMascotasDeunCliente (@PathVariable Integer idCliente)
    {
        return mascotaRepository.findByClienteId(idCliente);
    }
    // http://localhost:8080/mascotas/cliente/x
}
