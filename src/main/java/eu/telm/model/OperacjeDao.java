package eu.telm.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kasia on 13.11.16.
 */
public interface OperacjeDao extends JpaRepository<Operacja, Long> {
    List<Operacja> findById(Long id);
    //List<Operacja> findByNazwaStartsWithIgnoreCase(String nazwa);

}
