package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.Curso;
import com.miportfolio.nh.service.ICursoService;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CCurso {
    
    @Autowired
    private ICursoService iCurso;
    
    @GetMapping ("/curso/lista")
    public ResponseEntity<List<Curso>> list(){
        List<Curso> cursos = iCurso.getCurso();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    @GetMapping("/curso/detalle/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") int id){
        Optional<Curso> optionalCurso = iCurso.findById(id);
        if(optionalCurso.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Curso curso = optionalCurso.get();
    return new ResponseEntity<>(curso, HttpStatus.OK);
}

    @PostMapping("/curso/crear")
    public void save(@RequestBody Curso curso) {      
        iCurso.saveCurso(curso);
    }
    
    @DeleteMapping("/curso/borrar/{id}")
    public void delete(@PathVariable ("id") int id){
        iCurso.deleteCurso(id);
    }
    
    @PutMapping ("curso/editar/")
    public void editarCurso(@RequestBody Curso curso){
        iCurso.editarCurso(curso);
    }
    
    /*@PutMapping ("curso/editar/{id}")
    public Curso editCurso (@PathVariable int id,
                                  @RequestParam ("titulo") String nuevoTitulo,
                                  @RequestParam ("imag") String nuevaImag,
                                  @RequestParam ("dado") String nuevoDado,
                                  @RequestParam ("fecha") String nuevaFecha){
        Curso curso = iCurso.findCurso(id);
        curso.setTitulo(nuevoTitulo);
        curso.setImag (nuevaImag);
        curso.setDado(nuevoDado);
        curso.setFecha (nuevaFecha);
        
        iCurso.saveCurso(curso);
        return curso;
    }*/
    
}