package com.reservas.repository;

import com.reservas.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsientoRepository extends JpaRepository<Asiento, Long> {

    @Query(value = "SELECT count(a) FROM Asiento a " +
            "WHERE a.disponibilidad = true " +
            "AND a.idAvion = :idAvion")
    Long findCantidadAsientosDisponiblesByAvion(Long idAvion);

    @Query(value = "SELECT count(a) FROM Asiento a " +
            "WHERE a.disponibilidad = false " +
            "AND a.idAvion = :idAvion")
    Long findCantidadAsientosOcupadosByAvion(Long idAvion);
}
