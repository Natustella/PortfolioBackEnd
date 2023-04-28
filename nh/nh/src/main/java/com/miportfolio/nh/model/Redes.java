package com.miportfolio.nh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Redes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String url;
    
    @NotNull
    private String icoFont;

    public Redes() {
    }

    public Redes(String url, String icoFont) {
        this.url = url;
        this.icoFont = icoFont;
    }
    
    
    
    
}
