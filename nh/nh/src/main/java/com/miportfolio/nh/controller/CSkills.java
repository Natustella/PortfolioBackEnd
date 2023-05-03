package com.miportfolio.nh.controller;

import com.miportfolio.nh.model.Skills;
import com.miportfolio.nh.service.ISkillsService;
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
public class CSkills {

    @Autowired
    private ISkillsService iSkills;

    @GetMapping("/skills/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> skills = iSkills.getSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @GetMapping("/skills/detalle/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        Optional<Skills> optionalSkills = iSkills.findById(id);
        if(optionalSkills.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Skills skills = optionalSkills.get();
    return new ResponseEntity<>(skills, HttpStatus.OK);
}

    @PostMapping("/skills/crear")
    public void save(@RequestBody Skills skills) {
        iSkills.saveSkills(skills);
    }

    @DeleteMapping("/skills/borrar/{id}")
    public void delete(@PathVariable("id") int id) {
        iSkills.deleteSkills(id);
    }

    @PutMapping("skills/editar/{id}")
    public void editarSkills (@RequestParam Skills skills) {
        iSkills.editarSkills(skills);
    }
}
