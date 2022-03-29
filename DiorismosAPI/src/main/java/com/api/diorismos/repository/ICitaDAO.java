package com.api.diorismos.repository;

import com.api.diorismos.model.Cita;
import java.sql.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author allec
 */
@Repository
public interface ICitaDAO extends CrudRepository<Cita, Integer> {

    List<Cita> findAllByFecha(Date fecha);
}
