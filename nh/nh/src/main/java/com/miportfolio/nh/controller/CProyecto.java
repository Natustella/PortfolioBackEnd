package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.Proyecto;
import com.miportfolio.nh.model.Skills;
import com.miportfolio.nh.service.IProyectoService;
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
public class CProyecto {
    
    @Autowired
    private IProyectoService iProyecto;
    
    @GetMapping ("/proyecto/lista")
    public ResponseEntity<List<Proyecto>> list() {
    List<Proyecto> proyecto = iProyecto.getProyecto();
    return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @GetMapping("/proyecto/detalle/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        Optional<Proyecto> optionalProyecto = iProyecto.findById(id);
        if(optionalProyecto.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Proyecto proyecto = optionalProyecto.get();
    return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/proyecto/crear")
    public void save(@RequestBody Proyecto proyecto){
        iProyecto.saveProyecto(proyecto);
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public void delete(@PathVariable ("id") int id){
        iProyecto.deleteProyecto(id);
    }
    
    @PutMapping ("proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable int id,
                                  @RequestParam ("descripcion") String nuevaDescripcion){
        
        Proyecto proyecto = iProyecto.findProyecto(id);
        proyecto.setDescripcion (nuevaDescripcion);
        
        iProyecto.saveProyecto(proyecto);
        return proyecto;
    }
}
