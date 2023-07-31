package com.consultorio.consultorio.Repository;

import com.consultorio.consultorio.Domain.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPaciente extends JpaRepository<Pacientes, Integer> {
}
