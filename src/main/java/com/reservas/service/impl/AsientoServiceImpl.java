package com.reservas.service.impl;

import com.reservas.Enum.NombreGenerador;
import com.reservas.model.Asiento;
import com.reservas.repository.IAsientoRepository;
import com.reservas.service.interfaces.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl implements IAsientoService{

    private final IAsientoRepository iAsientoRepository;

    public List<Asiento> findAll(){
        return this.iAsientoRepository.findAll();
    }

    @Override
    public Long findCantidadAsientosDisponiblesByAvion(Long idAvion) {
        return this.iAsientoRepository.findCantidadAsientosDisponiblesByAvion(idAvion);
    }

    @Override
    public Long findCantidadAsientosOcupadosByAvion(Long idAvion) {
        return this.iAsientoRepository.findCantidadAsientosOcupadosByAvion(idAvion);
    }

    @Override
    public void crearAsientos(Long cantidad, Long idAvion) {
        List<String> nombresAsientos = NombreGenerador.generarNombres(cantidad);
        for (String nombre: nombresAsientos) {
            Asiento asiento = new Asiento();
            if (nombre.charAt(0) == 'A' || nombre.charAt(0) == 'B'
                    || nombre.charAt(0) == 'C') {
                asiento.setAsiento(nombre);
                asiento.setClase("Primera Clase");
                asiento.setPrecio(500F);
                asiento.setIdAvion(idAvion);
                asiento.setDisponibilidad(true);
            }else{
                asiento.setAsiento(nombre);
                asiento.setClase("Económica");
                asiento.setPrecio(250F);
                asiento.setIdAvion(idAvion);
                asiento.setDisponibilidad(true);
            }
            this.iAsientoRepository.save(asiento);
        }
    }

    @Autowired
    public AsientoServiceImpl(IAsientoRepository iAsientoRepository) {
        this.iAsientoRepository = iAsientoRepository;
    }
}
