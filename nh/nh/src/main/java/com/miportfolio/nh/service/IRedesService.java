package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Redes;
import java.util.List;
import java.util.Optional;

public interface IRedesService {
    
    public List<Redes> getRedes ();
    public void saveRedes (Redes redes);
    public void deleteRedes (int id);
    public Redes findRedes (int id);
    public Optional<Redes> findById(int id);
    public boolean existsById(int id);
    public void editarRedes(Redes redes);
}
