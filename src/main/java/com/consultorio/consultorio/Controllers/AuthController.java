package com.consultorio.consultorio.Controllers;

import com.consultorio.consultorio.Domain.Usuarios;
import com.consultorio.consultorio.Dto.AuthDTO;
import com.consultorio.consultorio.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private RepositoryUsuario repositoryUsuario;


    @PostMapping("/login")
    @Transactional
    public ResponseEntity auth(@RequestBody AuthDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody AuthDTO dados){
//    if(this.repositoryUsuario.findByEmail(dados.email()) !=null) return ResponseEntity.badRequest().build();
//    String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
//        Usuarios newUser = new Usuarios();
//    }

}
