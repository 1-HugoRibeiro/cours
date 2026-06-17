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

    @Test
    void testWeb() throws exception {

        Echantillon E = new Echantillon();
        E.setNombreDeVoitures(2);
        E.setPrixMoyen(14500);

        when(stats.prixMoyen()).thenReturn(E);

        mockMvc.perform(get("/statistique")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExcept(status().isOk());
            .andExcept(jsonPath("$.nombreDeVoitures").value(2));
            .andExcept(jsonPath("$.prixMoyen").value(14500));
    }

}
