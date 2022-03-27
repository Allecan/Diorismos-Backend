package com.api.diorismos.repository;

import com.api.diorismos.model.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author allec
 */
@Repository
public interface IPacienteDAO extends CrudRepository<Paciente, Integer> {

    Paciente findByDpi(String dpi);

    boolean existsByDpi(String dpi);
}
