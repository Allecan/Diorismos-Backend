package com.api.diorismos.service;

import com.api.diorismos.model.Cita;
import com.api.diorismos.repository.ICitaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allec
 */
@Service
public class CitaService {

    @Autowired
    private ICitaDAO citaDAO;

    public List<Cita> listarCitas() {
        return (List<Cita>) citaDAO.findAll();
    }

    public Cita guardarCita(Cita nuevaCita) {
        return citaDAO.save(nuevaCita);
    }
}
