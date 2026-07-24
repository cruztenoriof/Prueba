package com.gina.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Medico extends JpaRepository<Medico, Long> {
}
