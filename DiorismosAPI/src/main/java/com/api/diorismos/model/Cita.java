/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.diorismos.model;

//import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author allec
 */
@Data
@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cita")
    private Integer idCita;
    private Date fecha;
    private String hora;
    private Short status;
    @Column(name = "paciente_id_Paciente")    
    private Integer pacienteIdPaciente;
}
