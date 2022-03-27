/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.diorismos.model;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author allec
 */
@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Paciente")
    private Integer idPaciente;
    private String dpi;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_Nacimiento")
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String celular;
}
