package com.reservas.repository;

import com.reservas.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAvionRepository extends JpaRepository<Avion, Long> {

    @Query(value = "SELECT a FROM Avion a " +
            "WHERE a.aerolinea_id = :id")
    List<Avion> findAvionByAerolinea_id(Long id);
}