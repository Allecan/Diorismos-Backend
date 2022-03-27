/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.api.diorismos.endpoint;

import com.api.diorismos.model.Paciente;
import com.api.diorismos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author allec
 */
@RestController
@RequestMapping("/paciente")
public class PacienteEndpoint {
    
    @Autowired
    private PacienteService pacienteService;
    
    @GetMapping("/find/{dpi}")
    public Boolean findDPI(@PathVariable("dpi") String dpi) {
        return pacienteService.existePaciente(dpi);
    }
    
    @PostMapping("/crear")
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        if (!pacienteService.existePaciente(paciente.getDpi())) {
            return pacienteService.guardarPaciente(paciente);
        }
        return pacienteService.obtenerPaciente(paciente.getDpi());
    }
    
}
