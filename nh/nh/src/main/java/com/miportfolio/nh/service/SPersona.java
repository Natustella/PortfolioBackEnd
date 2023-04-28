package com.miportfolio.nh.service;

import com.miportfolio.nh.model.MPersona;
import com.miportfolio.nh.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona implements IPersonaService{
    
    @Autowired
    RPersona rPers;

    @Override
    public List<MPersona> getPersona() {
        List<MPersona> listaPersona = rPers.findAll();
        return listaPersona;
    }

    @Override
    public void savePersona(MPersona pers) {
        rPers.save(pers);
    }

    @Override
    public void deletePersona(int id) {
        rPers.deleteById(id);
    }

    @Override
    public MPersona findPersona(int id) {
        MPersona pers = rPers.findById(id).orElse(null);
        return pers;
    }

 
}
