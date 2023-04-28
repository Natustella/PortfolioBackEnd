package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.Redes;
import com.miportfolio.nh.service.IRedesService;
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
public class CRedes {
      
    @Autowired
    private IRedesService iRedes;
    
    @GetMapping("/redes/lista")
    public ResponseEntity<List<Redes>> list() {
        List<Redes> redes = iRedes.getRedes();
        return new ResponseEntity<>(redes, HttpStatus.OK);
    }
    
    @GetMapping("/redes/detalle/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") int id){
        Optional<Redes> optionalRedes = iRedes.findById(id);
        if(optionalRedes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Redes redes = optionalRedes.get();
    return new ResponseEntity<>(redes, HttpStatus.OK);
    }
    
    @PostMapping("/redes/crear")
    public void save(@RequestBody Redes redes) {
        iRedes.saveRedes(redes);
    }
    
    @DeleteMapping("/redes/borrar/{id}")
    public void delete(@PathVariable("id") int id) {
        iRedes.deleteRedes(id);
    }
    
    @PutMapping("redes/editar/{id}")
    public Redes editRedes(@PathVariable int id,
                             @RequestParam("url") String nuevaUrl,
                             @RequestParam ("icoFont") String nuevoIcoFont) {

        Redes redes = iRedes.findRedes(id);
        redes.setUrl(nuevaUrl);
        redes.setIcoFont(nuevoIcoFont);

        iRedes.saveRedes(redes);
        return redes;
    }
}
