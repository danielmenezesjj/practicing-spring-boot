package com.consultorio.consultorio.Controllers;


import com.consultorio.consultorio.Repository.RepositoryTipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
