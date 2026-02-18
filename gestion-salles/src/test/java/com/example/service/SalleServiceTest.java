package com.example.service;

import com.example.model.Salle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class SalleServiceTest {

    private EntityManagerFactory emf;
    private SalleService salleService;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("gestion-salles");
        salleService = new SalleService(emf);
    }

    @After
    public void tearDown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    public void testCrudSalle() {

        // CREATE
        Salle salle = new Salle("JUnit Room", 25);
        salle.setEtage(1);
        salle.setDisponible(true);

        Salle created = salleService.create(salle);
        assertNotNull(created.getId());

        // READ
        Optional<Salle> found = salleService.getById(created.getId());
        assertTrue(found.isPresent());
        assertEquals("JUnit Room", found.get().getNom());

        // UPDATE
        Salle toEdit = found.get();
        toEdit.setCapacite(45);
        salleService.edit(toEdit);

        Optional<Salle> updated = salleService.getById(created.getId());
        assertTrue(updated.isPresent());
        assertEquals(Integer.valueOf(45), updated.get().getCapacite());

        // DELETE
        salleService.remove(updated.get());
        Optional<Salle> deleted = salleService.getById(created.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testSallesDisponibles() {

        Salle s1 = new Salle("Libre", 30);
        s1.setDisponible(true);

        Salle s2 = new Salle("Occupée", 20);
        s2.setDisponible(false);

        salleService.create(s1);
        salleService.create(s2);

        List<Salle> libres = salleService.listerDisponibles(true);
        assertTrue(libres.stream().anyMatch(s -> s.getNom().equals("Libre")));
        assertFalse(libres.stream().anyMatch(s -> s.getNom().equals("Occupée")));

        salleService.remove(s1);
        salleService.remove(s2);
    }

    @Test
    public void testCapaciteMinimum() {

        Salle petite = new Salle("Petite", 10);
        Salle moyenne = new Salle("Moyenne", 60);
        Salle grande = new Salle("Grande", 120);

        salleService.create(petite);
        salleService.create(moyenne);
        salleService.create(grande);

        List<Salle> min50 = salleService.sallesAvecCapaciteMin(50);
        assertEquals(2, min50.size());

        List<Salle> min100 = salleService.sallesAvecCapaciteMin(100);
        assertEquals(1, min100.size());

        salleService.remove(petite);
        salleService.remove(moyenne);
        salleService.remove(grande);
    }
}
