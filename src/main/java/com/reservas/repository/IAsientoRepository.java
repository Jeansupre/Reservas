package com.reservas.repository;

import com.reservas.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsientoRepository extends JpaRepository<Asiento, Long> {
}
