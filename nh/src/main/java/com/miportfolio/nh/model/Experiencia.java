package com.miportfolio.nh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String pos;
    
    @NotNull
    @Size(min = 1, max = 400)
    private String logo;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String empresa;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String desde;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String hasta;
    
    @NotNull
    @Size(min = 1, max = 500)
    private String actividad;

    public Experiencia() {
    }

    public Experiencia(int id, String pos, String logo, String empresa, String desde, String hasta, String actividad) {
        this.id = id;
        this.pos = pos;
        this.logo = logo;
        this.empresa = empresa;
        this.desde = desde;
        this.hasta = hasta;
        this.actividad = actividad;
    }
    
}
