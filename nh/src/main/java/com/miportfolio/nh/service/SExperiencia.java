package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Experiencia;
import com.miportfolio.nh.repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia implements IExperienciaService {
    
    @Autowired
    private RExperiencia rExp;
    
    @Override
    public List<Experiencia> getExperiencia() {
        return rExp.findAll();
    }
    
    public Experiencia getOne(int id) {
        Experiencia expe = rExp.findById(id).orElse(null);
        return expe;
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        rExp.save(exp); 
    }
    
    @Override
    public void deleteExperiencia(int id) {
        rExp.deleteById(id);
    }
    public void edit(Experiencia exp){
        rExp.save(exp);
    }
    
    @Override
    public Experiencia findExperiencia(int id) {
        Experiencia exp = rExp.findById(id).orElse(null);
        return exp;
    }

    @Override
    public Optional<Experiencia> findById(int id) {
        return rExp.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rExp.existsById(id);
    }

    @Override
    public void editarExperiencia(Experiencia experiencia) {
        Optional<Experiencia> exp = rExp.findById(experiencia.getId());
        
        if(exp.isPresent()){
            Experiencia experien = exp.get();
            experien.setPos(experiencia.getPos());
            experien.setLogo(experiencia.getLogo());
            experien.setEmpresa(experiencia.getEmpresa());
            experien.setDesde(experiencia.getDesde());
            experien.setHasta(experiencia.getHasta());
            experien.setActividad(experiencia.getActividad());
            rExp.save(experien);
        }else{
            throw new RuntimeException("Experience not fount");
        }
    }
    
}