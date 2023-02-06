package com.example.spring_mysql.service;

import com.example.spring_mysql.model.Poistenec;
import com.example.spring_mysql.model.PoistenieMajetku;
import com.example.spring_mysql.repository.PoistenecRepository;
import com.example.spring_mysql.repository.PoistenieMajetkuRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class PoistenieMajetkuService {

    private PoistenieMajetkuRepository poistenieMajetkuRepository;

    public PoistenieMajetkuService(PoistenieMajetkuRepository poistenieMajetkuRepository) {
        super();
        this.poistenieMajetkuRepository = poistenieMajetkuRepository;
    }


    public PoistenieMajetku savePoistenieMajetku(PoistenieMajetku poistenieMajetku) {


        Set<String> types = new HashSet<String>() {{
            add("BYT");
            add("RODINNY_DOM_MUROVANY");
            add("RODINNY_DOM_DREVENY");

        }};

        if (poistenieMajetku.getObec().length() != 0 && poistenieMajetku.getUlica().length() != 0 &&
                poistenieMajetku.getPsc().toString().length() != 0 &&
                poistenieMajetku.getOrientacne_domu().toString().length()
                        != 0 && poistenieMajetku.getHodnota() != null
                && types.contains(poistenieMajetku.getTypNehnutelnosti()) ) {

            return poistenieMajetkuRepository.save(poistenieMajetku);

        }
        else {
            return null;
        }

    }


}
