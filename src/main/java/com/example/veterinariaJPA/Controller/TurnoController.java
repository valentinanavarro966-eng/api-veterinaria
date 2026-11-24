package com.example.veterinariaJPA.Controller;

import com.example.veterinariaJPA.DTO.TurnoDTO;
import com.example.veterinariaJPA.Model.Cliente;
import com.example.veterinariaJPA.Model.Mascota;
import com.example.veterinariaJPA.Model.Turno;
import com.example.veterinariaJPA.Model.Veterinario;
import com.example.veterinariaJPA.Repository.ClienteRepository;
import com.example.veterinariaJPA.Repository.MascotaRepository;
import com.example.veterinariaJPA.Repository.TurnoRepository;
import com.example.veterinariaJPA.Repository.VeterinarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public TurnoController(TurnoRepository turnoRepository,
                           ClienteRepository clienteRepository,
                           MascotaRepository mascotaRepository,
                           VeterinarioRepository veterinarioRepository) {
        this.turnoRepository = turnoRepository;
        this.clienteRepository = clienteRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @GetMapping
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }
    // http://localhost:8080/turnos

    @GetMapping("/{id}")
    public Turno buscarTurnoXid(@PathVariable Integer id) {
        return turnoRepository.findById(id).orElse(null);
    }
    // http://localhost:8080/turnos/x

    @PostMapping
    public Turno crearTurno(@RequestBody TurnoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getId_cliente()).orElseThrow();
        Mascota mascota = mascotaRepository.findById(dto.getId_mascota()).orElseThrow();
        Veterinario veterinario = veterinarioRepository.findById(dto.getId_veterinaria()).orElseThrow();

        Turno turno = new Turno();
        turno.setFecha(dto.getFecha());
        turno.setHora(dto.getHora());
        turno.setMotivo(dto.getMotivo());
        turno.setEstado(dto.getEstado());
        turno.setCliente(cliente);
        turno.setVeterinario(veterinario);
        turno.setMascota(mascota);
        return turnoRepository.save(turno);
    }
    // http://localhost:8080/turnos

    @PutMapping("/{id}")
    public Turno modificarTurno (@PathVariable Integer id, @RequestBody TurnoDTO dto)
    {
        Turno turno= turnoRepository.findById(id).orElseThrow();
        turno.setFecha(dto.getFecha());
        turno.setHora(dto.getHora());
        turno.setEstado(dto.getEstado());
        turno.setMotivo(dto.getMotivo());

        Cliente cliente= clienteRepository.findById(dto.getId_cliente()).orElseThrow();
        Veterinario veterinario= veterinarioRepository.findById(dto.getId_veterinaria()).orElseThrow();
        Mascota mascota= mascotaRepository.findById(dto.getId_mascota()).orElseThrow();

        turno.setCliente(cliente);
        turno.setVeterinario(veterinario);
        turno.setMascota(mascota);

        return turnoRepository.save(turno);
    }
    // http://localhost:8080/turnos/x

    @DeleteMapping("/{id}")
    public void eliminarTurno (@PathVariable Integer id)
    {
        turnoRepository.deleteById(id);
    }
    // http://localhost:8080/turnos/x

    @GetMapping("/veterinario/{idVeterinario}")
    public List<Turno> listarTurnosDeVeterinario (@PathVariable Integer idVeterinario)
    {
        return turnoRepository.findByVeterinarioId(idVeterinario);
    }
    // http://localhost:8080/turnos/veterinario/x








}
