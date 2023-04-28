package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.MPersona;
import com.miportfolio.nh.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CPersona {

    @Autowired
    IPersonaService iPers;
    
    
    @GetMapping("/persona/perfil")
    public MPersona findPersona() {
        return iPers.findPersona((int) 1);
    }

    @GetMapping("/persona/traer")
    public List<MPersona> getPersona() {
        return iPers.getPersona();
    }

    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody MPersona pers) {
        iPers.savePersona(pers);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        iPers.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("persona/editar/{id}")
    public MPersona editPersona(@PathVariable int id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("position") String nuevaPosition,
            @RequestParam("ubicacion") String nuevaUbicacion,
            @RequestParam("imgMe") String nuevaImagen,
            @RequestParam("sobreMi") String nuevoSobreMi) {
        MPersona pers = iPers.findPersona(id);
        pers.setNombre(nuevoNombre);
        pers.setPosition(nuevaPosition);
        pers.setUbicacion(nuevaUbicacion);
        pers.setImgMe(nuevaImagen);
        pers.setSobreMi(nuevoSobreMi);

        iPers.savePersona(pers);
        return pers;
    }

}
