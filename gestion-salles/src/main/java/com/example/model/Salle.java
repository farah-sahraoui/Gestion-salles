package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la salle est requis")
    @Size(min = 3, max = 80, message = "Le nom doit contenir entre 3 et 80 caractères")
    @Column(nullable = false)
    private String nom;

    @NotNull(message = "Capacité obligatoire")
    @Min(value = 5, message = "La capacité minimale est de 5 places")
    @Max(value = 800, message = "La capacité maximale est de 800 places")
    @Column(nullable = false)
    private Integer capacite;

    @Size(max = 400, message = "La description ne doit pas dépasser 400 caractères")
    @Column(length = 400)
    private String description;

    @NotNull(message = "Disponibilité obligatoire")
    @Column(nullable = false)
    private Boolean disponible = true;

    @Min(value = 0, message = "L'étage doit être positif")
    private Integer etage;

    // Constructeur JPA
    public Salle() {
    }

    public Salle(String nom, Integer capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getEtage() {
        return etage;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }

    @Override
    public String toString() {
        return "Salle [id=" + id +
                ", nom=" + nom +
                ", capacite=" + capacite +
                ", description=" + description +
                ", disponible=" + disponible +
                ", etage=" + etage + "]";
    }
}
