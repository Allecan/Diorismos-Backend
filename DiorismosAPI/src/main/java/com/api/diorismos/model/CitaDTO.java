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
public class CitaDTO {

    private String fecha;
    private String hora;
    private Short status; 
    private Integer pacienteIdPaciente;
}
