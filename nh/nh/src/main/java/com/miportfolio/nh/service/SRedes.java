package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Redes;
import com.miportfolio.nh.repository.RRedes;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedes implements IRedesService {
    
    @Autowired
    private RRedes rRedes;

    @Override
    public List<Redes> getRedes() {
        return rRedes.findAll();
    }

    @Override
    public void saveRedes(Redes redes) {
        rRedes.save(redes);
    }

    @Override
    public void deleteRedes(int id) {
        rRedes.deleteById(id);
    }

    @Override
    public Redes findRedes(int id) {
        Redes redes = rRedes.findById(id).orElse(null);
        return redes;
    }

    @Override
    public Optional<Redes> findById(int id) {
        return rRedes.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rRedes.existsById(id);
    }

}