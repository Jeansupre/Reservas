package com.reservas.repository;

import com.reservas.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IAerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
