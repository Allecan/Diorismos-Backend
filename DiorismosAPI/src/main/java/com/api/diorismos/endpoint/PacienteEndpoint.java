/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.api.diorismos.endpoint;

import com.api.diorismos.model.Paciente;
import com.api.diorismos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author allec
 */
@CrossOrigin()
@RestController
@RequestMapping("/paciente")
public class PacienteEndpoint {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        if (!pacienteService.existePaciente(paciente.getDpi())) {
            return new ResponseEntity<>(pacienteService.guardarPaciente(paciente),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>(pacienteService.obtenerPaciente(paciente.getDpi()),
                HttpStatus.OK);
    }

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola desde diorismos";
    }
}
