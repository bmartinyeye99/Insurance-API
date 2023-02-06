package com.example.spring_mysql.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "cestovne_poistenie")
public class PoistenieCestovne {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCestovnePoistenie;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Column(name = "zaciatok", nullable = false)
    private String zaciatok;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Column(name = "koniec", nullable = false)
    private String koniec;

    @Column(name="typ_poistenia")
    private String typPoistenia;


    public PoistenieCestovne(String zaciatok, String koniec, String typPoistenia) {
        this.zaciatok = zaciatok;
        this.koniec = koniec;
        this.typPoistenia = typPoistenia;
    }

    public PoistenieCestovne() {

    }

    public Long getIdCestovnePoistenie() {
        return idCestovnePoistenie;
    }

    public String getZaciatok() {
        return zaciatok;
    }

    public String getKoniec() {
        return koniec;
    }

    public String getTypPoistenia() {
        return typPoistenia;
    }
}
