/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.diorismos.endpoint;

import com.api.diorismos.model.Cita;
import com.api.diorismos.service.CitaService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author allec
 */
@RestController
@RequestMapping("/cita")
public class CitaEndpoint {

    @Autowired
    private CitaService citaService;

    @PostMapping("/crear")
    public Cita crearCita(@RequestBody Cita nuevaCita) {
        return citaService.guardarCita(nuevaCita);
    }

    @GetMapping("/find/reserved/{fecha}")
    public List<String> encontrarCita(@PathVariable("fecha") String fecha) {
        List<Cita> citasReservadas = citaService.listarCitasReservadas(Date.valueOf(fecha));
        List<String> citasString = new ArrayList<>();
        for (Cita cita : citasReservadas) {
            citasString.add(cita.getHora());
        }
        return citasString;
    }

    @GetMapping("/find/available/{fecha}")
    public List<String> encontrarCitasDisponibles(@PathVariable("fecha") String fecha) {
        return citaService.findAppointsAvailable(fecha);
    }
}
