package com.example.spring_mysql.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "korespondecna_adresa")
public class KorespondecnaAdresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Psc")
    private Integer psc;

    @Column(name = "Obec")
    private String obec;

    @Column(name = "Ulica")
    private String ulica;

    @Column(name = "Orientacne_domu")
    private Integer orientacneCisloDomu;

    @JsonIgnore
    @OneToOne(mappedBy = "korespondecnaAdresa")
    private Poistenec poistenec;


    public KorespondecnaAdresa(Long id, Integer psc, String obec, String ulica, Integer orientacne_domu) {
        this.id = id;
        this.psc = psc;
        this.obec = obec;
        this.ulica = ulica;
        this.orientacneCisloDomu = orientacne_domu;
    }

    public KorespondecnaAdresa() {

    }

    public Integer getPsc() {
        return psc;
    }

    public String getObec() {
        return obec;
    }

    public String getUlica() {
        return ulica;
    }

    public Integer getOrientacneCisloDomu() {
        return orientacneCisloDomu;
    }
}
