package eu.telm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Każda tabelka posiada te pola
 * czyli id, date stworzenia
 */
@MappedSuperclass
public class DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createAt = new Date();

    public Long getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
