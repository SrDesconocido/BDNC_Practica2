/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.BDNC;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author octav
 */
@RestController
@RequestMapping("/url")
public class ControlerPersona {
    @Autowired
    private RepositoryPersona repositoryPersona;
    @GetMapping()
    public List<Persona> list() {
        return repositoryPersona.findAll();
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable String id) {
            Optional <Persona> optPersona = repositoryPersona.findById(id);
        return optPersona.orElse (null);
    }
    
    @PutMapping("/{id}")
    public Persona put(@PathVariable String id, @RequestBody Persona persona) {
            Optional<Persona> optionalPersona = repositoryPersona.findById(id);
            if (optionalPersona.isPresent()) {
                persona = optionalPersona.get();
                persona.setId(persona.getId());
                persona.setNombre(persona.getNombre());
                persona.setDireccion(persona.getDireccion());
                persona.setTelefono(persona.getTelefono());
                return repositoryPersona.save(persona);
            } else {
                return null;
            }

    }
    
    @PostMapping
    public Persona post(@RequestBody Persona persona) {
         return repositoryPersona.save(persona);

    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repositoryPersona.deleteById(id);

    }
    
}
