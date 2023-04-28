package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Skills;
import java.util.List;
import java.util.Optional;

public interface ISkillsService {
    
    public List<Skills> getSkills ();
    public void saveSkills (Skills skills);
    public void deleteSkills (int id);
    public Skills findSkills (int id);
    public Optional<Skills> findById(int id);
    public boolean existsById(int id);
}
