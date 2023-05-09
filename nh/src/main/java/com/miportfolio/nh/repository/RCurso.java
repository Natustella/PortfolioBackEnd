package com.miportfolio.nh.repository;

import com.miportfolio.nh.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCurso extends JpaRepository<Curso, Integer> {
    
}
