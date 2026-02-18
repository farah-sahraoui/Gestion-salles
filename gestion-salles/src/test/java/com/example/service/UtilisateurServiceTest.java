package com.example.service;

import com.example.model.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class UtilisateurServiceTest {

    private EntityManagerFactory emf;
    private UtilisateurService utilisateurService;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("gestion-salles");
        utilisateurService = new UtilisateurService(emf);
    }

    @After
    public void cleanUp() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    public void testCycleCrudUtilisateur() {

        // CREATE
        Utilisateur u = new Utilisateur("JUnit", "Tester", "junit.tester@mail.com");
        u.setDateNaissance(LocalDate.of(1995, 6, 10));
        u.setTelephone("+212600112233");

        Utilisateur created = utilisateurService.create(u);
        assertNotNull(created.getId());

        // READ
        Optional<Utilisateur> found = utilisateurService.getById(created.getId());
        assertTrue(found.isPresent());
        assertEquals("JUnit", found.get().getNom());

        // UPDATE
        Utilisateur toEdit = found.get();
        toEdit.setPrenom("UpdatedTester");
        utilisateurService.edit(toEdit);

        Optional<Utilisateur> updated = utilisateurService.getById(created.getId());
        assertTrue(updated.isPresent());
        assertEquals("UpdatedTester", updated.get().getPrenom());

        // DELETE
        utilisateurService.remove(updated.get());
        Optional<Utilisateur> deleted = utilisateurService.getById(created.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testRechercheParEmail() {

        Utilisateur u = new Utilisateur("Email", "Check", "email.check@mail.com");
        utilisateurService.create(u);

        Optional<Utilisateur> found =
                utilisateurService.rechercherParEmail("email.check@mail.com");

        assertTrue(found.isPresent());
        assertEquals("Email", found.get().getNom());

        Optional<Utilisateur> notFound =
                utilisateurService.rechercherParEmail("absent@mail.com");

        assertFalse(notFound.isPresent());

        utilisateurService.remove(found.get());
    }

    @Test
    public void testGetAllUtilisateurs() {

        Utilisateur u1 = new Utilisateur("Alpha", "One", "alpha.one@mail.com");
        Utilisateur u2 = new Utilisateur("Beta", "Two", "beta.two@mail.com");

        utilisateurService.create(u1);
        utilisateurService.create(u2);

        List<Utilisateur> list = utilisateurService.getAll();
        assertTrue(list.size() >= 2);

        utilisateurService.remove(u1);
        utilisateurService.remove(u2);
    }
}
