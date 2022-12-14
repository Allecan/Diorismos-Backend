package com.api.diorismos.service;

import com.api.diorismos.model.Cita;
import com.api.diorismos.model.CitaDTO;
import com.api.diorismos.repository.ICitaDAO;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Cita guardarCita(CitaDTO nuevaCita) {

        Cita cita = new Cita();
        cita.setFecha(Date.valueOf(nuevaCita.getFecha()));
        cita.setHora(nuevaCita.getHora());
        cita.setPacienteIdPaciente(nuevaCita.getPacienteIdPaciente());
        cita.setStatus(Short.parseShort("0"));

        Date fechaHoy = new Date(System.currentTimeMillis());
        if (cita.getFecha().toString().equals(fechaHoy.toString())) {
            return citaDAO.save(cita);
        }
        if (cita.getFecha().compareTo(fechaHoy) < 0) {
            return null;
        }
        return citaDAO.save(cita);
    }

    public List<Cita> listarCitasReservadas(Date fecha) {
        return citaDAO.findAllByFecha(fecha);
    }

    public List<String> findAppointsAvailable(String fecha) {
        Date fechaHoy = new Date(System.currentTimeMillis());
        Date fechaSoli = Date.valueOf(fecha);
        Time horaActual = new Time(System.currentTimeMillis());
        Time horaLimite = Time.valueOf("20:00:00");
        List<String> citasDisponibles = new ArrayList<>();
        List<Cita> citasReservadas = citaDAO.findAllByFecha(fechaSoli);
        if (fecha.equals(fechaHoy.toString())) {
            int horaLimiteI = Integer.parseInt(horaLimite.toString().substring(0, 2))
                    - Integer.parseInt(horaActual.toString().substring(0, 2));
            for (int i = 1; i < horaLimiteI; i++) {
                citasDisponibles.add(String.valueOf(i
                        + Integer.parseInt(horaActual.toString().
                                substring(0, 2))) + ":00");
            }
            for (Cita citaReservada : citasReservadas) {
                citasDisponibles.remove("14:00");
                citasDisponibles.remove(citaReservada.getHora().substring(0, 5));
            }
            return citasDisponibles;
        }
        if (fechaSoli.compareTo(fechaHoy) < 0) {
            return citasDisponibles;
        }
        for (int i = 9; i < Integer.parseInt(horaLimite.toString().substring(0, 2)); i++) {
            citasDisponibles.add(String.valueOf(i) + ":00");
        }
        for (Cita citaReservada : citasReservadas) {
            citasDisponibles.remove("14:00");
            citasDisponibles.remove(citaReservada.getHora().substring(0, 5));
        }
        return citasDisponibles;
    }
}
