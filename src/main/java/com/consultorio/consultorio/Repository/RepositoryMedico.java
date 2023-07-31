package com.consultorio.consultorio.Repository;

import com.consultorio.consultorio.Domain.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMedico extends JpaRepository<Medicos, Integer> {
}
