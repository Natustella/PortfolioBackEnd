package com.miportfolio.nh.repository;

import com.miportfolio.nh.model.MPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository <MPersona, Integer>{
    
}
