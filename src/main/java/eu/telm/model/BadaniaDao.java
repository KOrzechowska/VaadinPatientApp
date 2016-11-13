package eu.telm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kasia on 13.11.16.
 */
public interface BadaniaDao extends JpaRepository<Badanie, Long> {

    List<Badanie> findByPatient_Id(Long id);
    //List<Badanie> findByPatientStartsWithIgnoreCase(Patient patient);

}
