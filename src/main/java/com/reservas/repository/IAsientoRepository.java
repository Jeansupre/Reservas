package com.reservas.repository;

import com.reservas.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query(value = "SELECT a FROM Asiento a " +
            "WHERE a.asiento LIKE :nombre")
    List<Asiento> findAsientoByAsiento(String nombre);

    @Query(value = "SELECT a FROM Asiento a " +
            "WHERE a.asiento LIKE :nombre " +
            "AND a.idAvion = :idAvion")
    List<Asiento> findAsientoByAsientoAndIdAvion(String nombre, Long idAvion);
}
