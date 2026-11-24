package com.example.veterinariaJPA.Controller;

import com.example.veterinariaJPA.Model.Cliente;
import com.example.veterinariaJPA.Repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    //http://localhost:8080/clientes

    @GetMapping("/{id}")
    public Cliente buscarClienteXid(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
    //http://localhost:8080/clientes/x

    @PostMapping
    public Cliente crearCliente (@RequestBody Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }
    //http://localhost:8080/clientes

    @PutMapping("/{id}")
    public Cliente modificarCliente (@PathVariable Integer id, @RequestBody Cliente cliente)
    {
        Cliente clienteAmodificar = clienteRepository.findById(id).orElseThrow();
        clienteAmodificar.setNombre(cliente.getNombre());
        clienteAmodificar.setApellido(cliente.getApellido());
        clienteAmodificar.setEmail(cliente.getEmail());
        clienteAmodificar.setDireccion(cliente.getDireccion());
        clienteAmodificar.setTelefono(cliente.getTelefono());
        clienteAmodificar.setActivo(cliente.isActivo());

        return clienteRepository.save(clienteAmodificar);
    }
    //http://localhost:8080/clientes/x

}
