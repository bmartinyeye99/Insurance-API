package com.example.spring_mysql.model;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Data
@Entity
@Table(name = "poistenieMajetku")
public class PoistenieMajetku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Column(name = "Datum_vzniku", nullable = false)
    private String datumVzniku;

    @Column(name = "Hodnota", nullable = false)
    private Integer hodnota;

    @Column(name = "Typ_nehnutelnosti", nullable = false)
    private String typNehnutelnosti;

    @Column(name = "Psc", nullable = false)
    private Integer psc;

    @Column(name = "Obec", nullable = false)
    private String obec;

    @Column(name = "Ulica", nullable = false)
    private String ulica;

    @Column(name = "Orientacne_domu", nullable = false)
    private Integer orientacne_domu;


    public PoistenieMajetku() {

    }

    public PoistenieMajetku(String datumVzniku, Integer hodnota, String typNehnutelnosti,
                            Integer psc, String obec, String ulica, Integer orientacne_domu) {
        this.datumVzniku = datumVzniku;
        this.hodnota = hodnota;
        this.typNehnutelnosti = typNehnutelnosti;
        this.psc = psc;
        this.obec = obec;
        this.ulica = ulica;
        this.orientacne_domu = orientacne_domu;
    }

    public Long getId() {
        return id;
    }

    public String getDatumVzniku() {
        return datumVzniku;
    }

    public Integer getHodnota() {
        return hodnota;
    }

    public String getTypNehnutelnosti() {
        return typNehnutelnosti;
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

    public Integer getOrientacne_domu() {
        return orientacne_domu;
    }


}
