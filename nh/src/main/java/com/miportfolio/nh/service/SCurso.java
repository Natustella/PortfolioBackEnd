package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Curso;
import com.miportfolio.nh.repository.RCurso;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCurso implements ICursoService{
    
    @Autowired
    private RCurso rCurso;

    @Override
    public List<Curso> getCurso() {
        return rCurso.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        rCurso.save(curso);
    }

    @Override
    public void deleteCurso(int id) {
        rCurso.deleteById(id);
    }

    @Override
    public Curso findCurso(int id) {
        Curso curso = rCurso.findById(id).orElse(null);
        return curso;
    }

    @Override
    public Optional<Curso> findById(int id) {
        return rCurso.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rCurso.existsById(id);
    }

    @Override
    public void editarCurso(Curso curso) {
        Optional <Curso> cur = rCurso.findById(curso.getId());
        
        if(cur.isPresent()){
            Curso cursito = cur.get();
            cursito.setTitulo(curso.getTitulo());
            cursito.setImag(curso.getImag());
            cursito.setDado(curso.getDado());
            cursito.setFecha(curso.getFecha());
            rCurso.save(cursito);
        }else{
            throw new RuntimeException("Curso not fount");
        }
    }

}