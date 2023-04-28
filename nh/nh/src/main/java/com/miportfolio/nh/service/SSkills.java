package com.miportfolio.nh.service;

import com.miportfolio.nh.model.Skills;
import com.miportfolio.nh.repository.RSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills implements ISkillsService{
    
    @Autowired
    private RSkills rSkills;

    @Override
    public List<Skills> getSkills() {
        return rSkills.findAll();
    }

    @Override
    public void saveSkills(Skills skills) {
        rSkills.save(skills);
    }

    @Override
    public void deleteSkills(int id) {
        rSkills.deleteById(id);
    }

    @Override
    public Skills findSkills(int id) {
        Skills skills = rSkills.findById(id).orElse(null);
        return skills;
    }

    @Override
    public Optional<Skills> findById(int id) {
        return rSkills.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return rSkills.existsById(id);
    }

}
