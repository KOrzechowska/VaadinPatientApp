package eu.telm.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by kasia on 13.11.16.
 */
@Entity
@Table(name = "slownik_operacji")
public class Operacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nazwa;
    private String opis;
    public enum typ{BADANIE, ZABIEG};
    @Enumerated(EnumType.STRING)
    private typ typ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Badanie> badanieList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Badanie> getBadanieList() {
        return badanieList;
    }

    public void setBadanieList(List<Badanie> badanieList) {
        this.badanieList = badanieList;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Operacja.typ getTyp() {
        return typ;
    }

    public void setTyp(Operacja.typ typ) {
        this.typ = typ;
    }
}
