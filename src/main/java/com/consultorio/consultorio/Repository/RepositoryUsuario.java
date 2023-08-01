package com.consultorio.consultorio.Repository;

import com.consultorio.consultorio.Domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuarios, Integer> {
}
