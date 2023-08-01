package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Domain.Usuarios;
import com.consultorio.consultorio.Dto.UsuarioDTO;
import com.consultorio.consultorio.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private RepositoryUsuario repository;

    @GetMapping
    public ResponseEntity getAllUser(){
        var allUser = repository.findAll();
        return ResponseEntity.ok(allUser);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postUser(@RequestBody UsuarioDTO data){
        Usuarios newUser = new Usuarios(data);
        repository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
