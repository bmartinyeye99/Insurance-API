package com.example.spring_mysql.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.springframework.http.HttpStatusCode;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "poistenci")
public class Poistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poistenec")
    private Long id;

    //    @Pattern(regexp = "[a-zA-Z]+", message = "Name can contain only letters!")
    @NotBlank(message = "name required!")
    private String meno;

    // @Pattern(regexp = "[a-zA-Z]+", message = "Lastname can contain only letters!")
    //@Column(name = "Priezvisko", nullable = false)
    @NotBlank(message = "LastName required!")
    private String priezvisko;

    //@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "must have valid email format")
    //@Column(name = "Email", nullable = false, unique = true)
    @NotBlank(message = "email required!")
    private String email;

    //@Pattern(regexp="[\\d]{10}", message="RC should have 10 digits!")
    @Column(name = "Rc", nullable = false, unique = true)
    @NotNull
    private Long rc;

    //@Pattern(regexp="[\\d]{5}", message="PSC should contain 5 digits!")
    //@Column(name = "Psc", nullable = false)
    @NotNull
    private Integer psc;

    //@Pattern(regexp="[a-zA-Z]+", message = "Settlement should contain only letters!")
    //@Column(name = "Obec", nullable = false)
    @NotBlank(message = "obec required!")
    private String obec;

    @NotBlank(message = "Street required!")
    private String ulica;

    //@Pattern(regexp="[\\d]{5}", message="Max number of digits for house number is 5!")
    @Column(name = "Orientacne_domu", nullable = false)
    private Integer orientacneCislo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poistenec_id",
            referencedColumnName = "id_poistenec")
    private List<PoistenieMajetku> poisteniaMajetku;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poistenec_id",
            referencedColumnName = "id_poistenec")
    private List<PoistenieCestovne> cestovnePoistenia;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poistenec_id")
    private KorespondecnaAdresa korespondecnaAdresa;

    public Poistenec(String meno, String priezvisko, String email, Long rc, Integer psc,
                     String obec, String ulica, Integer orientacneCislo, KorespondecnaAdresa korespondecnaAdresa) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.email = email;
        this.rc = rc;
        this.psc = psc;
        this.obec = obec;
        this.ulica = ulica;
        this.orientacneCislo = orientacneCislo;
        this.korespondecnaAdresa = korespondecnaAdresa;
    }

    public Poistenec() {
    }

    public KorespondecnaAdresa getKorespondecnaAdresa() {
        return korespondecnaAdresa;
    }

    public void setKorespondecnaAdresa(KorespondecnaAdresa korespondecnaAdresa) {
        this.korespondecnaAdresa = korespondecnaAdresa;
    }

    public Long getId() {
        return id;
    }

    public String getMeno() {
        return meno;
    }

    public Long getRc() {
        return rc;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

//    public Long getRc() {
//        return rc;
//    }

    public String getEmail() {
        return email;
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

    public Integer getOrientacneCislo() {
        return orientacneCislo;
    }


}
