package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Domain.Medicos;
import com.consultorio.consultorio.Dto.MedicosDTO;
import com.consultorio.consultorio.Repository.RepositoryMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequestMapping("/medicos")
@RestController
public class MedicoController {
    @Autowired
    private RepositoryMedico repositoryMedico;

    @GetMapping
    public ResponseEntity getAllMedicos(){
        var allMedicos = repositoryMedico.findAll();
        return ResponseEntity.ok(allMedicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postMedicos(@RequestBody MedicosDTO data, UriComponentsBuilder uriComponentsBuilder){
        Medicos newMedico = new Medicos(data);
        repositoryMedico.save(newMedico);
        URI uri = uriComponentsBuilder.path("/medicos/${id}").buildAndExpand(newMedico.getId_medico()).toUri();
        return ResponseEntity.created(uri).body(new Medicos(data));

    }
    @PutMapping("/{id_medico}")
    @Transactional
    public ResponseEntity putMedicos(@RequestBody MedicosDTO data, @PathVariable Integer id_medico){
        var medico = repositoryMedico.getReferenceById(id_medico);
        medico.updateMedico(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id_medico}")
    public ResponseEntity deleteMedico(@PathVariable Integer id_medico){
        Optional<Medicos> optionalMedicos = repositoryMedico.findById(id_medico);
        if(optionalMedicos.isPresent()){
            Medicos medicos = optionalMedicos.get();
            repositoryMedico.delete(medicos);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
