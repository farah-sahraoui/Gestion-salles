package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 3, max = 40, message = "Le nom doit avoir entre 3 et 40 caractères")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "Le prénom est requis")
    @Size(min = 3, max = 40, message = "Le prénom doit avoir entre 3 et 40 caractères")
    @Column(nullable = false)
    private String prenom;

    @NotBlank(message = "Adresse email obligatoire")
    @Email(message = "Adresse email non valide")
    @Column(nullable = false, unique = true)
    private String email;

    @Past(message = "La date de naissance doit être antérieure à aujourd’hui")
    private LocalDate dateNaissance;

    @Pattern(regexp = "^[0-9+]{9,14}$", message = "Numéro de téléphone invalide")
    private String telephone;

    // Constructeur vide obligatoire
    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", email=" + email +
                ", dateNaissance=" + dateNaissance +
                ", telephone=" + telephone + "]";
    }
}
