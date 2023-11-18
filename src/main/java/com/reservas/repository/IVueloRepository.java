package com.reservas.repository;

import com.reservas.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVueloRepository extends JpaRepository<Vuelo, Long> {
}
