package com.remedios.projeto.repositories;

import com.remedios.projeto.domain.remedio.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    List<Remedio> findAllByAtivoTrue();
}
