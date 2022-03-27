/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.api.diorismos.service;

import com.api.diorismos.model.Paciente;
import com.api.diorismos.repository.IPacienteDAO;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allec
 */
@Service
public class PacienteService {

    @Autowired
    private IPacienteDAO pacienteDAO;

    public boolean existePaciente(String dpi) {
        return pacienteDAO.existsByDpi(dpi);
    }

    public Paciente guardarPaciente(Paciente nuevoPaciente) {
        return pacienteDAO.save(nuevoPaciente);
    }

    public Paciente obtenerPaciente(String dpi) {
        return pacienteDAO.findByDpi(dpi);
    }
}
