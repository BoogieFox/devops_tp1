package com.example.devops_tp1.controller;

import com.example.devops_tp1.model.Servant;
import com.example.devops_tp1.service.ServantService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ServantController.class)
class ServantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServantService servantService;

    @Test
    void testGetAllServants() throws Exception {
        Servant s1 = new Servant("Artoria", "Saber", 5);
        List<Servant> mockServants = List.of(s1);
        when(servantService.getAllServants()).thenReturn(mockServants);

        mockMvc.perform(get("/api/servants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Artoria"))
                .andExpect(jsonPath("$[0].sClass").value("Saber")); // json path requires exact mapping property name, let's verify if getter sets property to "sClass"
    }

    @Test
    void testGetServantByNameFound() throws Exception {
        Servant s1 = new Servant("Gilgamesh", "Archer", 5);
        when(servantService.getServantByName("Gilgamesh")).thenReturn(Optional.of(s1));

        mockMvc.perform(get("/api/servants/Gilgamesh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gilgamesh"));
    }

    @Test
    void testGetServantByNameNotFound() throws Exception {
        when(servantService.getServantByName("Unknown")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/servants/Unknown"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateServant() throws Exception {
        Servant s1 = new Servant("Jeanne d'Arc", "Ruler", 5);
        when(servantService.addServant(any(Servant.class))).thenReturn(s1);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/api/servants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(s1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jeanne d'Arc"));
    }
}
