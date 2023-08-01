package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Domain.TiposDeUsuario;
import com.consultorio.consultorio.Dto.TipoUsuarioDTO;
import com.consultorio.consultorio.Repository.RepositoryTipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/tiposUsuario")
public class TipoUsuarioController {

    @Autowired
    private RepositoryTipoUsuario repository;

    @GetMapping
    public ResponseEntity getAlltypeUser(){
        var allTypesUser = repository.findAll();
        return ResponseEntity.ok(allTypesUser);
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody TipoUsuarioDTO data, UriComponentsBuilder uriComponentsBuilder){
        TiposDeUsuario newTypeUser = new TiposDeUsuario(data);
        repository.save(newTypeUser);
        URI uri = uriComponentsBuilder.path("/tipoUsuario/${id}").buildAndExpand(newTypeUser.getId_tipousuario()).toUri();
        return ResponseEntity.created(uri).body(new TiposDeUsuario(data));
    }

    @PutMapping("/{id_tipo_usuario}")
    @Transactional
    public ResponseEntity putTypeUser(@RequestBody TipoUsuarioDTO data, @PathVariable Integer id_tipo_usuario){
        var typeUser = repository.getReferenceById(id_tipo_usuario);
        typeUser.updateTypeUser(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id_tipo_usuario}")
    public ResponseEntity deleteTypeUser(@PathVariable Integer id_tipo_usuario){
        Optional<TiposDeUsuario> optionalTiposDeUsuario = repository.findById(id_tipo_usuario);
        if(optionalTiposDeUsuario.isPresent()){
            TiposDeUsuario tiposDeUsuario = optionalTiposDeUsuario.get();
            repository.delete(tiposDeUsuario);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
