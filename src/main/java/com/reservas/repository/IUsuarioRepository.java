package com.reservas.repository;

import com.reservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "Select u from Usuario u where " +
            "TRANSLATE(UPPER(u.documento), 'ÁÉÍÓÚ', 'AEIOU') LIKE TRANSLATE(UPPER(:documento), 'ÁÉÍÓÚ', 'AEIOU')")
    Usuario findUsuarioByDocumento(String documento);

    @Query(value = "Select u from Usuario u where " +
            "TRANSLATE(UPPER(u.correo), 'ÁÉÍÓÚ', 'AEIOU') LIKE TRANSLATE(UPPER(:correo), 'ÁÉÍÓÚ', 'AEIOU')")
    List<Usuario> findUsuarioByCorreo(String correo);
}
