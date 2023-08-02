package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Domain.TiposDeUsuario;
import com.consultorio.consultorio.Domain.Usuarios;
import com.consultorio.consultorio.Dto.UsuarioDTO;
import com.consultorio.consultorio.Repository.RepositoryTipoUsuario;
import com.consultorio.consultorio.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private RepositoryUsuario repository;

    @Autowired
    private RepositoryTipoUsuario repositoryTipoUsuario;

    @GetMapping
    public ResponseEntity getAllUser(){
        var allUser = repository.findAll();
        return ResponseEntity.ok(allUser);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postUser(@RequestBody UsuarioDTO data){

        var tipoUser = repositoryTipoUsuario.getReferenceById(data.tipo_usuario_id());
        Optional<TiposDeUsuario> optionalTiposDeUsuario = repositoryTipoUsuario.findById(data.tipo_usuario_id());
        if(optionalTiposDeUsuario.isPresent()){
            Usuarios newUser = new Usuarios(data, tipoUser);
            repository.save(newUser);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
