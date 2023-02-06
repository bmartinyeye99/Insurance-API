package com.example.spring_mysql.service;

import com.example.spring_mysql.model.Poistenec;

import java.util.List;

public interface PoistenecService {


    public Poistenec savePoistenec(Poistenec poistenec);
    public List<Poistenec> getAllPoistencov();
    public Poistenec getPoistenecById(long id);
    public List<String> checkJson(Poistenec poistenec);
    public void checkKorrespondecna(Poistenec poistenec);
}
