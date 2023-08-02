package com.consultorio.consultorio.Repository;

import com.consultorio.consultorio.Domain.TiposDeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTipoUsuario extends JpaRepository<TiposDeUsuario, Integer> {

}
