package com.example.spring_mysql.service;

import com.example.spring_mysql.model.KorespondecnaAdresa;
import com.example.spring_mysql.model.Poistenec;
import com.example.spring_mysql.model.PoistenieMajetku;
import com.example.spring_mysql.repository.KorespondacnaAdresaRepository;
import com.example.spring_mysql.repository.PoistenecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PoistenecServiceImpl implements PoistenecService {

    Set<String> types = new HashSet<String>() {
        {
            add("Byt");
            add("Rodinny_dom_murovany");
            add("Rodinny_dom_dreveny");
        }
    };


    private PoistenecRepository poistenecRepository;

    @Autowired
    private KorespondacnaAdresaRepository korespondacnaAdresaRepository;

    public PoistenecServiceImpl(PoistenecRepository poistenecRepository) {
        this.poistenecRepository = poistenecRepository;
    }

    public List<String> checkPoistenie(List<String> errs, Poistenec poistenec) {
        for (PoistenieMajetku poistenieMajetku : poistenec.getPoisteniaMajetku()) {
            if (poistenieMajetku.getUlica().isEmpty())
                errs.add("Ulica has to be filed");
            if (poistenieMajetku.getObec().isEmpty())
                errs.add("Obec has to be added");
            if (poistenieMajetku.getDatumVzniku().isEmpty())
                errs.add("Datum has to be added");
            if (poistenieMajetku.getPsc() == 0)
                errs.add("PSC has to be added");
            if (types.contains(poistenieMajetku.getTypNehnutelnosti()) == false)
                errs.add("Add the type!");
        }
        return errs;

    }

    public List<String> checkJson(Poistenec poistenec) {
        List<String> errors = new ArrayList<String>();

        if (poistenec.getMeno().length() == 0)
            errors.add("Name has to be filled! ");
        if (poistenec.getPriezvisko().length() == 0)
            errors.add("Last name has to be filled! ");
        if (poistenec.getEmail().length() == 0 || poistenec.getEmail().contains("@") == false)
            errors.add("Email has to be filled! ");
        if (poistenec.getRc().toString().length() != 10)
            errors.add("RC has to have 10 digits! ");
        if (poistenec.getObec().length() == 0)
            errors.add("Settlement has to be filled! ");
        if (poistenec.getUlica().length() == 0)
            errors.add("Street has to be filled! ");
        if (poistenec.getPsc().toString().length() != 5)
            errors.add("PSC has to have 5 digits! ");
        if (poistenec.getOrientacneCislo().toString().length() == 0)
            errors.add("Street number has to be filled! ");
        if (poistenec.getPoisteniaMajetku() != null)
            errors = checkPoistenie(errors, poistenec);


        return errors;
    }

    public void checkKorrespondecna(Poistenec poistenec) {

        if (poistenec.getKorespondecnaAdresa() == null) {
            KorespondecnaAdresa korespondecnaAdresa = new KorespondecnaAdresa();
            korespondecnaAdresa.setObec(poistenec.getObec());
            korespondecnaAdresa.setPsc(poistenec.getPsc());
            korespondecnaAdresa.setUlica(poistenec.getUlica());
            korespondecnaAdresa.setOrientacneCisloDomu(poistenec.getOrientacneCislo());
            korespondacnaAdresaRepository.save(korespondecnaAdresa);
            poistenec.setKorespondecnaAdresa(korespondecnaAdresa);
        }
    }

    @Override
    public Poistenec savePoistenec(Poistenec poistenec) {

        checkKorrespondecna(poistenec);
        return poistenecRepository.save(poistenec);

    }


    @Override
    public List<Poistenec> getAllPoistencov() {
        return poistenecRepository.findAll(Sort.by(Sort.Direction.ASC, "priezvisko"));
    }


    @Override
    public Poistenec getPoistenecById(long id) {
        Optional<Poistenec> poistenec = poistenecRepository.findById(id);
        return poistenec.get();


    }


}
