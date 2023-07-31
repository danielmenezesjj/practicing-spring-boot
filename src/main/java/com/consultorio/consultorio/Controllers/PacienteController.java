package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Domain.Pacientes;
import com.consultorio.consultorio.Dto.PacientesDTO;
import com.consultorio.consultorio.Repository.RepositoryPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private RepositoryPaciente repository;

    @GetMapping
    public ResponseEntity getAllPacientes(){
        var allPacientes = repository.findAll();
        return ResponseEntity.ok(allPacientes);
    }
    @PostMapping
    @Transactional
    public ResponseEntity postPacientes(@RequestBody PacientesDTO data, UriComponentsBuilder uriComponentsBuilder){
        Pacientes newPaciente = new Pacientes(data);
        repository.save(newPaciente);
        URI uri = uriComponentsBuilder.path("/pacientes/${id}").buildAndExpand(newPaciente.getId_paciente()).toUri();
        return ResponseEntity.created(uri).body(new Pacientes(data));
    }

    @PutMapping("/{id_paciente}")
    @Transactional
    public ResponseEntity putPacientes(@RequestBody PacientesDTO data, @PathVariable Integer id_paciente){
        var paciente = repository.getReferenceById(id_paciente);
        paciente.updatePacientes(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id_paciente}")
    public ResponseEntity deletePaciente(@PathVariable Integer id_paciente){
        Optional<Pacientes> optionalPacientes = repository.findById(id_paciente);
        if(optionalPacientes.isPresent()){
            Pacientes pacientes = optionalPacientes.get();
            repository.delete(pacientes);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }



}
