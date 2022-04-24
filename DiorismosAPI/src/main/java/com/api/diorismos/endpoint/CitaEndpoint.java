/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.diorismos.endpoint;

import com.api.diorismos.model.CitaDTO;
import com.api.diorismos.service.CitaService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
@RequestMapping("/cita")
public class CitaEndpoint {

    @Autowired
    private CitaService citaService;

    @GetMapping("/available/{fecha}")
    public ResponseEntity<?> encontrarCitasDisponibles(@PathVariable("fecha") String fecha) {
        HashMap<String, Object> response = new HashMap<>();
        List<String> citasDisponibles = citaService.findAppointsAvailable(fecha);
        if (citasDisponibles.isEmpty()) {
            response.put("ErrorMessage", "Escoga una fecha valida, mayor o igual a hoy");
            response.put("Fecha", fecha);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return new ResponseEntity<>(citasDisponibles, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> crearCita(@RequestBody CitaDTO nuevaCita) {
        return new ResponseEntity<>(citaService.guardarCita(nuevaCita), HttpStatus.CREATED);
    }
}
