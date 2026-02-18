package com.example;

import com.example.model.Salle;
import com.example.model.Utilisateur;
import com.example.service.SalleService;
import com.example.service.UtilisateurService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("gestion-salles");

        UtilisateurService utilisateurService = new UtilisateurService(emf);
        SalleService salleService = new SalleService(emf);

        try {
            System.out.println("===== DÉMARRAGE DES TESTS CRUD =====");

            verifierCrudUtilisateur(utilisateurService);
            verifierCrudSalle(salleService);

        } finally {
            emf.close();
            System.out.println("===== FIN DES TESTS =====");
        }
    }

    // ================= UTILISATEUR =================

    private static void verifierCrudUtilisateur(UtilisateurService service) {

        System.out.println("\n--- CRUD UTILISATEUR ---");

        // CREATE
        Utilisateur u1 = new Utilisateur("El Amrani", "Youssef", "youssef.amrani@mail.com");
        u1.setDateNaissance(LocalDate.of(1992, 3, 12));
        u1.setTelephone("+212612345678");

        Utilisateur u2 = new Utilisateur("Benali", "Imane", "imane.benali@mail.com");
        u2.setDateNaissance(LocalDate.of(1996, 7, 8));
        u2.setTelephone("+212698745632");

        service.create(u1);
        service.create(u2);

        // READ ALL
        System.out.println("\nListe des utilisateurs :");
        service.getAll().forEach(System.out::println);

        // READ BY ID
        System.out.println("\nRecherche utilisateur ID = 1");
        Optional<Utilisateur> userOpt = service.getById(1L);
        userOpt.ifPresent(System.out::println);

        // READ BY EMAIL
        System.out.println("\nRecherche utilisateur par email :");
        service.rechercherParEmail("imane.benali@mail.com")
                .ifPresent(System.out::println);

        // UPDATE
        System.out.println("\nMise à jour téléphone utilisateur :");
        userOpt.ifPresent(u -> {
            u.setTelephone("+212611223344");
            service.edit(u);
            System.out.println("Utilisateur modifié : " + u);
        });

        // DELETE
        System.out.println("\nSuppression utilisateur ID = 2");
        service.removeById(2L);

        System.out.println("\nUtilisateurs après suppression :");
        service.getAll().forEach(System.out::println);
    }

    // ================= SALLE =================

    private static void verifierCrudSalle(SalleService service) {

        System.out.println("\n--- CRUD SALLE ---");

        // CREATE
        Salle s1 = new Salle("Salle Informatique", 40);
        s1.setDescription("Salle équipée de PC");
        s1.setEtage(1);

        Salle s2 = new Salle("Amphi Central", 250);
        s2.setDescription("Amphithéâtre principal");
        s2.setEtage(0);

        Salle s3 = new Salle("Salle Réunion", 15);
        s3.setDisponible(false);
        s3.setEtage(2);

        service.create(s1);
        service.create(s2);
        service.create(s3);

        // READ ALL
        System.out.println("\nToutes les salles :");
        service.getAll().forEach(System.out::println);

        // READ BY ID
        System.out.println("\nSalle ID = 2 :");
        Optional<Salle> salleOpt = service.getById(2L);
        salleOpt.ifPresent(System.out::println);

        // READ DISPONIBLES
        System.out.println("\nSalles disponibles :");
        List<Salle> disponibles = service.listerDisponibles(true);
        disponibles.forEach(System.out::println);

        // READ CAPACITÉ MIN
        System.out.println("\nSalles avec capacité >= 100 :");
        service.sallesAvecCapaciteMin(100)
                .forEach(System.out::println);

        // UPDATE
        System.out.println("\nMise à jour capacité salle :");
        salleOpt.ifPresent(s -> {
            s.setCapacite(300);
            service.edit(s);
            System.out.println("Salle modifiée : " + s);
        });

        // DELETE
        System.out.println("\nSuppression salle ID = 3");
        service.removeById(3L);

        System.out.println("\nSalles après suppression :");
        service.getAll().forEach(System.out::println);
    }
}
