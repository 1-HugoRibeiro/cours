package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Testvoid
    void statistiquesVoitureAccessible() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2, 200000));

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(200000));
    }

    @Test
    void aucuneVoiture() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenThrow(ArithmeticException.class);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void postVoitureFonctionne() throws Exception {
        String v1Json = "{\"marque\":\"Ferrari\",\"prix\":150000}";

        mockMvc.perform(post("/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(voitureJson))
                .andExpect(status().isOk());

        verify(statistiqueImpl, times(1)).ajouter(any(Voiture.class));
    }

    @Test
    void postVoitureFonctionne2() throws Exception {
        String v2Json = "{\"marque\":\"Lamborghini\",\"prix\":250000}";
        
        mockMvc.perform(post("/v2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(v2Json))
            .andExpect(status().isOk());
    }

}
