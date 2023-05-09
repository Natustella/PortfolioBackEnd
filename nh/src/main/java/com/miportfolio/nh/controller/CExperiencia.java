package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.Experiencia;
import com.miportfolio.nh.service.IExperienciaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    private IExperienciaService iExp;
    
    @GetMapping ("/experiencia/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> experiencias = iExp.getExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    @GetMapping("/experiencia/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        Optional<Experiencia> optionalExperiencia = iExp.findById(id);
        if(optionalExperiencia.isEmpty())
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Experiencia exp = optionalExperiencia.get();
    return new ResponseEntity<>(exp, HttpStatus.OK);
}

    @PostMapping("/experiencia/crear")
    public void save(@RequestBody Experiencia expe) {      
        iExp.saveExperiencia(expe);
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public void delete(@PathVariable ("id") int id){
        iExp.deleteExperiencia(id);
    }
    
        @PutMapping ("experiencia/editar/")
    public void editarExperiencia(@RequestBody Experiencia experiencia){
        iExp.editarExperiencia(experiencia);
    }
    
}
