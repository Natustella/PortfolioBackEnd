package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    
    public List <Experiencia> getExperiencia ();
    public void saveExperiencia(Experiencia exp);
    public void deleteExperiencia (int id);
    public Experiencia findExperiencia (int id); 
    public Optional<Experiencia> findById(int id);
    public boolean existsById(int id);
}
