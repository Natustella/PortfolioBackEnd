package com.miportfolio.nh.repository;

import com.miportfolio.nh.model.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRedes extends JpaRepository<Redes, Integer>{
    
}
