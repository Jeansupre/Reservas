package com.reservas.repository;

import com.reservas.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Long> {

    @Query(value = "SELECT v FROM Vuelo v " +
            "WHERE v.idAerolinea = :id")
    List<Vuelo> findVuelosByIdAerolinea(Long id);
}
