package com.example.spring_mysql.controller;

import com.example.spring_mysql.model.Poistenec;
import com.example.spring_mysql.service.PoistenecService;
import com.example.spring_mysql.service.PoistenecServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/zadanieUN/insured")
public class PoistenecController {

    private PoistenecService poistenecService;


    public PoistenecController(PoistenecService poistenecService) {
        this.poistenecService = poistenecService;
    }

    @PostMapping
    public ResponseEntity savePoistenec(@RequestBody Poistenec poistenec) {
        List<String> errors = new ArrayList<String>();
        errors = poistenecService.checkJson(poistenec);

        ResponseEntity response;
        if (errors.isEmpty()) {
            Poistenec saved = poistenecService.savePoistenec(poistenec);
            response = new ResponseEntity(saved.getId(), HttpStatus.OK);
        } else
            response = new ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY);

        return response;

    }

    @GetMapping
    public List<Poistenec> getAllPoistencov() {

        return poistenecService.getAllPoistencov();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poistenec> getPoistenecById(@PathVariable("id") long poistenecID) {

        return new ResponseEntity<Poistenec>(poistenecService.getPoistenecById(poistenecID), HttpStatus.OK);
    }

}
