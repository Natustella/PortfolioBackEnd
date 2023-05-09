package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Proyecto;
import com.miportfolio.nh.repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto implements IProyectoService{
    
    @Autowired
    private RProyecto rProyecto;

    @Override
    public List<Proyecto> getProyecto() {
        return rProyecto.findAll();
    }

    @Override
    public void saveProyecto(Proyecto pro) {
        rProyecto.save(pro);
    }

    @Override
    public void deleteProyecto(int id) {
        rProyecto.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(int id) {
        Proyecto proyecto = rProyecto.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public Optional<Proyecto> findById(int id) {
        return rProyecto.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rProyecto.existsById(id);
    }

    @Override
    public void editarProyecto(Proyecto proyecto) {
                Optional <Proyecto> pro = rProyecto.findById(proyecto.getId());
        
        if(pro.isPresent()){
            Proyecto proyec = pro.get();
            proyec.setDescripcion(proyecto.getDescripcion());
            rProyecto.save(proyec);
        }else{
            throw new RuntimeException("Proyecto not fount");
        }
    }
}