package com.consultorio.consultorio.Repository;

import com.consultorio.consultorio.Domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuarios, Integer> {

    UserDetails findByEmail(String email);

}
