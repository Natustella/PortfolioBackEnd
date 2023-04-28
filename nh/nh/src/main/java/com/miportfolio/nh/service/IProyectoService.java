package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Proyecto;
import java.util.List;
import java.util.Optional;

public interface IProyectoService {
    
    public List <Proyecto> getProyecto ();
    public void saveProyecto(Proyecto proyecto);
    public void deleteProyecto (int id);
    public Proyecto findProyecto (int id);
    public Optional<Proyecto> findById(int id);
    public boolean existsById(int id);
}
