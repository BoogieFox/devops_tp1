package com.example.devops_tp1.service;

import com.example.devops_tp1.model.Servant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServantServiceTest {

    private ServantService servantService;

    @BeforeEach
    void setUp() {
        servantService = new ServantService();
    }

    @Test
    void testGetAllServants() {
        List<Servant> servants = servantService.getAllServants();
        assertThat(servants).hasSize(7);
    }

    @Test
    void testGetServantByNameFound() {
        Optional<Servant> servant = servantService.getServantByName("Gilgamesh");
        assertTrue(servant.isPresent());
        assertThat(servant.get().getsClass()).isEqualTo("Archer");
    }

    @Test
    void testGetServantByNameNotFound() {
        Optional<Servant> servant = servantService.getServantByName("Unknown");
        assertFalse(servant.isPresent());
    }

    @Test
    void testAddServant() {
        Servant newServant = new Servant("Merlin", "Caster", 5);
        servantService.addServant(newServant);

        assertThat(servantService.getAllServants()).hasSize(8);
        Optional<Servant> findMerlin = servantService.getServantByName("Merlin");
        assertTrue(findMerlin.isPresent());
        assertThat(findMerlin.get().getRarity()).isEqualTo(5);
    }
}
