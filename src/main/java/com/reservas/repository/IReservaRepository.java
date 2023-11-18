package com.reservas.repository;

import com.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
}
