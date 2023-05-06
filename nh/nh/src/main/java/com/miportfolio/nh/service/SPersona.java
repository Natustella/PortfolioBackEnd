package com.miportfolio.nh.service;

import com.miportfolio.nh.model.MPersona;
import com.miportfolio.nh.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<MPersona> findById(int id) {
        return rPers.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rPers.existsById(id);
    }

    @Override
    public void editarPersona(MPersona pers) {
        Optional <MPersona> per = rPers.findById(pers.getId());
        
        if(per.isPresent()){
            MPersona yo = per.get();
            yo.setImgMe(pers.getImgMe());
            yo.setNombre(pers.getNombre());
            yo.setPosition(pers.getPosition());
            yo.setUbicacion(pers.getUbicacion());
            yo.setSobreMi(pers.getSobreMi());
        }else {
            throw new RuntimeException("Persona not fount");
        }
    }
}
