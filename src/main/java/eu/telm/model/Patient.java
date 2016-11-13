package eu.telm.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

/**
 * Created by kasia on 12.11.16.
 */
@Entity
@Table(name = "pacjenci")
public class Patient  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String imie;
    //@NotNull
    private String nazwisko;
    //@NotNull
    private String pesel;
    //@NotNull
    private Date dataUr;
    //@NotNull
    private String plec;
    //@NotNull
    private String nrTel;
    //@NotNull
    private String email;
    //@NotNull
    private String kodPocztowy;
    //@NotNull
    private String miasto;
    //@NotNull
    private String ulica;
    //@NotNull
    private String nrDomu;
    //@NotNull
    private boolean czyUbezp;

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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public boolean isCzyUbezp() {
        return czyUbezp;
    }

    public void setCzyUbezp(boolean czyUbezp) {
        this.czyUbezp = czyUbezp;
    }


}
