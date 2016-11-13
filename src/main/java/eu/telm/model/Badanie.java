package eu.telm.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by kasia on 13.11.16.
 */
@Entity
@Table(name = "realizacje")
public class Badanie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date data;
    private String wynik;
    private String uwagi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable=true)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="operacja_id", nullable=true)
    private Operacja operacja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public Operacja getOperacja() {
        return operacja;
    }

    public void setOperacja(Operacja operacja) {
        this.operacja = operacja;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
